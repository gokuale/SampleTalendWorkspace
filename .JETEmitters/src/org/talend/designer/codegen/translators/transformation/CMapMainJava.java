package org.talend.designer.codegen.translators.transformation;

import org.talend.transform.component.thmap.MapperComponent;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.components.IComponent;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CMapMainJava
{
  protected static String nl;
  public static synchronized CMapMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CMapMainJava result = new CMapMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "                        .from(\"tdm:/\"+";
  protected final String TEXT_2 = "+\"?devWorkspace=\"+";
  protected final String TEXT_3 = "+\"&devInstall=\"+";
  protected final String TEXT_4 = "+(!\"\".equals(";
  protected final String TEXT_5 = ")?\"&projectArchives=\"+";
  protected final String TEXT_6 = ":\"\")+(!\"\".equals(";
  protected final String TEXT_7 = ")?\"&projects=\"+";
  protected final String TEXT_8 = ":\"\")+\"&log=\"+";
  protected final String TEXT_9 = "+\"&exceptionThreshold=\"+";
  protected final String TEXT_10 = "+\"&outputType=\"+";
  protected final String TEXT_11 = ")";
  protected final String TEXT_12 = NL + "                        .to(\"tdm:/\"+";
  protected final String TEXT_13 = "+\"?devWorkspace=\"+";
  protected final String TEXT_14 = "+\"&devInstall=\"+";
  protected final String TEXT_15 = "+(!\"\".equals(";
  protected final String TEXT_16 = ")?\"&projectArchives=\"+";
  protected final String TEXT_17 = ":\"\")+(!\"\".equals(";
  protected final String TEXT_18 = ")?\"&projects=\"+";
  protected final String TEXT_19 = ":\"\")+\"&log=\"+";
  protected final String TEXT_20 = "+\"&exceptionThreshold=\"+";
  protected final String TEXT_21 = "+\"&outputType=\"+";
  protected final String TEXT_22 = ")";
  protected final String TEXT_23 = NL + "                from(\"tdm:/\"+";
  protected final String TEXT_24 = "+\"?devWorkspace=\"+";
  protected final String TEXT_25 = "+\"&devInstall=\"+";
  protected final String TEXT_26 = "+(!\"\".equals(";
  protected final String TEXT_27 = ")?\"&projectArchives=\"+";
  protected final String TEXT_28 = ":\"\")+(!\"\".equals(";
  protected final String TEXT_29 = ")?\"&projects=\"+";
  protected final String TEXT_30 = ":\"\")+\"&log=\"+";
  protected final String TEXT_31 = "+\"&exceptionThreshold=\"+";
  protected final String TEXT_32 = "+\"&outputType=\"+";
  protected final String TEXT_33 = ")";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
   	
	// Fills the dependency property of the component
	Set<String> projectsSet = ((MapperComponent)node.getExternalNode()).populateDependencies(0);
	Set<String> projectArchiveSet = ((MapperComponent)node.getExternalNode()).populateDependencies(MapperComponent.DEP_FOR_PROJECT_ARCHIVE);

    String mapPath = ElementParameterParser.getValue(node, "__HMAP_PATH__");
    mapPath =  ((MapperComponent)node.getExternalNode()).makeAbsoluteMapPath(mapPath);
	mapPath = MapperComponent.fixMapPath(mapPath);
    String log = ElementParameterParser.getValue(node, "__LOG__"); 
	log = TalendTextUtils.addQuotes(log); 
	String exceptionThreshold = ElementParameterParser.getValue(node, "__EXCEPTION__");  
	exceptionThreshold = TalendTextUtils.addQuotes(exceptionThreshold); 
	String outputType = ElementParameterParser.getValue(node, "__OUTPUT_TYPE__");  
	outputType = TalendTextUtils.addQuotes(outputType); 

	StringBuffer pa = new StringBuffer();
	int i = 0;
	for (String project : projectArchiveSet) {
		if (i++ > 0) {
			pa.append(",");
		}
		pa.append("classpath://__tdm/" + project.replace(" ", "%20") + ".zip");
	}
	
	i = 0;
	StringBuffer projectsBuff = new StringBuffer();
	for (String project : projectsSet) {
		if (i++ > 0) {
			projectsBuff.append(",");
		}
		projectsBuff.append(project);
	}
	
	String projectArchives = "";
	String projects = "";
	String devWorkspace = "";
	String devInstall= "";

	if (org.talend.designer.runprocess.ProcessorUtilities.isExportConfig()) { 
		projectArchives = pa.toString();
	} else {
		projects = projectsBuff.toString();
    	devWorkspace = ElementParameterParser.getValue(node.getProcess(), "__COMP_DEFAULT_FILE_DIR__");
    	devInstall = ElementParameterParser.getValue(node.getProcess(), "__PRODUCT_ROOT_DIR__");
	}    

	projectArchives = TalendTextUtils.addQuotes(projectArchives);
	projects = TalendTextUtils.addQuotes(projects);
	devWorkspace = TalendTextUtils.addQuotes(devWorkspace);    
	devInstall = TalendTextUtils.addQuotes(devInstall);
 
    List< ? extends IConnection> conns = node.getIncomingConnections();
    if (conns.size()>0) {
        IConnection iConnection = conns.get(0);
        INode source = iConnection.getSource();
        if ("cErrorHandler".equals(source.getComponent().getName())
            && source.getIncomingConnections().size() < 1){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(devInstall);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(projects);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(projects);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(log);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(exceptionThreshold);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputType);
    stringBuffer.append(TEXT_11);
    
                }else{

    stringBuffer.append(TEXT_12);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(devInstall);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(projects);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(projects);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(log);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(exceptionThreshold);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(outputType);
    stringBuffer.append(TEXT_22);
    
                }
        } else {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(mapPath);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(devWorkspace);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(devInstall);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(projectArchives);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(projects);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(projects);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(log);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(exceptionThreshold);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(outputType);
    stringBuffer.append(TEXT_33);
    
        }

    return stringBuffer.toString();
  }
}
