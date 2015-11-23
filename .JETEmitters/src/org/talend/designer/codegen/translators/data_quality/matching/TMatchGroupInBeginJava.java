package org.talend.designer.codegen.translators.data_quality.matching;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Object;
import org.eclipse.emf.common.util.EMap;
import org.talend.designer.tdqmatching.MatchingData;
import org.talend.designer.tdqmatching.RuleMatcher;
import org.talend.designer.tdqmatching.JoinkeyRecord;

public class TMatchGroupInBeginJava
{
  protected static String nl;
  public static synchronized TMatchGroupInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMatchGroupInBeginJava result = new TMatchGroupInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();  
cid = cid.replace("_GroupIn", "");


//mzhao TDQ-5981 add multi rule set feature. Get the multi rules from matching component external data.

List<List<Map<String, String>>> matchingRulesAll = new ArrayList<List<Map<String, String>>>();
MatchingData matchData = (MatchingData)node.getExternalNode().getExternalEmfData();
if (matchData != null && matchData.getRuleMatchers().size() > 0) {
  List<RuleMatcher> ruleMatchers = matchData.getRuleMatchers();
  for (RuleMatcher ruleMatcher : ruleMatchers) {
      List<Map<String, String>> matcherList = new ArrayList<Map<String, String>>();
      List<JoinkeyRecord> jionkeys = ruleMatcher.getJoinkeys();
      for (JoinkeyRecord joinKey : jionkeys) {
          EMap<String, Object> columnMap = joinKey.getColumnMap();
          Map<String,String> tmpMap = new HashMap<String,String>();
          for(String key: columnMap.keySet()){
              tmpMap.put(key, columnMap.get(key)==null?"":columnMap.get(key).toString());
          }
          matcherList.add(tmpMap);
      }
      //Add the parameter map
      EMap<String, Object> paramMap = ruleMatcher.getMatchParamMap();
      Map<String,String> paramMapTmp = new HashMap<String,String>();
      for(String key: paramMap.keySet()){
          paramMapTmp.put(key, paramMap.get(key)==null?"":paramMap.get(key).toString());
      }
      matcherList.add(paramMapTmp);
      
      matchingRulesAll.add(matcherList);
  }
}


if(matchingRulesAll.size()==0){
    //If no matching rules in external data, try to get to rule from JOIN_KEY table (which will be compatible to old version less than 5.3)
    matchingRulesAll = (List<List<Map<String, String>>>)ElementParameterParser.getMultiObjectValue(node, "__JOIN_KEY__");
    
    if(matchingRulesAll!=null&&matchingRulesAll.size()>0){
        List<Map<String, String>> matcherList = matchingRulesAll.get(0);
        
        //Add the parameter map of algorithm interval of each matching rule, and  algorithm name.
        Map<String,String> paramMapTmp = new HashMap<String,String>();
        //threshold of matching rule.
        String interval_rule = ElementParameterParser.getValue(node, "__INTERVAL__");
        paramMapTmp.put("INTERVAL_RULE", interval_rule);
        //Note that the algorithm name is only one, so no parameter need to be set currently.
        matcherList.add(paramMapTmp);
        matchingRulesAll.add(matcherList);
    }
    
}


    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
