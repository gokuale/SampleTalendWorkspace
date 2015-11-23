package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Map;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;
import org.talend.core.utils.TalendQuoteUtils;

public class Camel_headerJava
{
  protected static String nl;
  public static synchronized Camel_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_headerJava result = new Camel_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tprivate String propertyToString(Object obj){" + NL + "\t\t\t\tif(obj!=null && obj instanceof java.util.Date){" + NL + "\t\t\t\t\treturn String.format(\"yyyy-MM-dd HH:mm:ss;%tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\",obj);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\treturn String.valueOf(obj);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL;
  protected final String TEXT_2 = NL + "\t\t\t\tprivate org.apache.camel.component.mail.MailEndpoint getMailEndpoint(" + NL + "\t\t\t\t\t\tString uri, String username, String password, String subject," + NL + "\t\t\t\t\t\tString from, String to, String cc, String bcc) {" + NL + "\t\t\t\t\torg.apache.camel.component.mail.MailEndpoint endpoint = (org.apache.camel.component.mail.MailEndpoint) endpoint(uri);" + NL + "\t\t\t\t\torg.apache.camel.component.mail.MailConfiguration configuration = endpoint.getConfiguration();" + NL + "\t\t\t\t\tconfiguration.setUsername(username);" + NL + "\t\t\t\t\tconfiguration.setPassword(password);" + NL + "\t\t\t\t\tconfiguration.setSubject(subject);" + NL + "\t\t\t\t\tif(null != from && !\"\".equals(from)){" + NL + "\t\t\t\t\t\tconfiguration.setFrom(from);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != to && !\"\".equals(to)){" + NL + "\t\t\t\t\t\tconfiguration.setTo(to);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != cc && !\"\".equals(cc)){" + NL + "\t\t\t\t\t\tconfiguration.setCC(cc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != bcc && !\"\".equals(bcc)){" + NL + "\t\t\t\t\t\tconfiguration.setBCC(bcc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn endpoint;" + NL + "\t\t\t\t}";
  protected final String TEXT_3 = NL + "\t\t\tprivate org.apache.camel.component.file.remote.RemoteFileEndpoint<?> getFtpEndpoint(" + NL + "\t\t\t\t\tString uri, String server, Integer port, String username, String password," + NL + "\t\t\t\t\tString directory) {" + NL + "\t\t\t\torg.apache.camel.component.file.remote.RemoteFileEndpoint<?> endpoint;" + NL + "\t\t\t\tendpoint = (org.apache.camel.component.file.remote.RemoteFileEndpoint<?>) endpoint(uri);" + NL + "\t\t\t\torg.apache.camel.component.file.remote.RemoteFileConfiguration configuration = endpoint" + NL + "\t\t\t\t\t\t.getConfiguration();" + NL + "\t\t\t\tconfiguration.setUsername(username);" + NL + "\t\t\t\tconfiguration.setPassword(password);" + NL + "\t\t\t\tconfiguration.setHost(server);" + NL + "\t\t\t\tconfiguration.setPort(port.intValue());" + NL + "\t\t\t\tconfiguration.setDirectory(directory);" + NL + "\t\t\t\treturn endpoint;" + NL + "\t\t\t}";
  protected final String TEXT_4 = NL + "\t\t\tclass CXFConsumerBinding extends org.apache.camel.component.cxf.DefaultCxfBinding {" + NL + "\t\t\t\tprivate org.apache.camel.component.cxf.CxfEndpoint endpoint;" + NL + "" + NL + "\t\t\t\tpublic CXFConsumerBinding(org.apache.camel.component.cxf.CxfEndpoint endpoint){" + NL + "\t\t\t\t\tthis.endpoint = endpoint;" + NL + "\t\t\t\t\tsetHeaderFilterStrategy(consumerSoapHeaderFilter);" + NL + "\t\t\t\t}" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tprotected void propagateHeadersFromCamelToCxf(org.apache.camel.Exchange camelExchange," + NL + "\t\t\t\t\t\tMap<String, Object> camelHeaders, org.apache.cxf.message.Exchange cxfExchange," + NL + "\t\t\t\t\t\tMap<String, Object> cxfContext) {" + NL + "\t\t\t\t\tsuper.propagateHeadersFromCamelToCxf(camelExchange, camelHeaders, cxfExchange, cxfContext);" + NL + "\t\t\t\t\tObject samlToken = camelHeaders.get(\"samlToken\");" + NL + "\t\t\t\t\tif(samlToken == null){" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tMap<String, Object> properties = endpoint.getProperties();" + NL + "\t\t\t\t\tif(properties == null){" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tObject object = properties.get(org.apache.cxf.ws.security.SecurityConstants.STS_CLIENT);" + NL + "\t\t\t\t\tif(object == null || !(object instanceof org.apache.cxf.ws.security.trust.STSClient)){" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.trust.STSClient stsClient = (org.apache.cxf.ws.security.trust.STSClient) object;" + NL + "\t\t\t\t\tstsClient.setOnBehalfOf(samlToken);" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_5 = NL + "\t\t\t\tclass CXFProviderBinding extends org.apache.camel.component.cxf.DefaultCxfBinding{" + NL + "" + NL + "\t\t\t\t\t@Override" + NL + "\t\t\t\t\tprotected void propagateHeadersFromCxfToCamel( org.apache.cxf.message.Message cxfMessage," + NL + "\t\t\t\t\t\t\torg.apache.camel.Message camelMessage, org.apache.camel.Exchange camelExchange) {" + NL + "\t\t\t\t\t\tsuper.propagateHeadersFromCxfToCamel(cxfMessage, camelMessage, camelExchange);" + NL + "\t\t\t\t\t\tcamelExchange.getIn().removeHeader(\"samlToken\");" + NL + "\t\t\t\t\t\torg.apache.cxf.security.SecurityContext securityContext = cxfMessage.get(org.apache.cxf.security.SecurityContext.class);" + NL + "\t\t\t\t\t\tif(securityContext != null && securityContext instanceof org.apache.cxf.rt.security.saml.claims.SAMLSecurityContext){" + NL + "\t\t\t\t\t\t\torg.apache.cxf.rt.security.saml.claims.SAMLSecurityContext ssc = (org.apache.cxf.rt.security.saml.claims.SAMLSecurityContext) securityContext;" + NL + "\t\t\t\t\t\t\torg.w3c.dom.Element assertionElement = ssc.getAssertionElement();" + NL + "\t\t\t\t\t\t\tif(assertionElement != null){" + NL + "\t\t\t\t\t\t\t\tcamelExchange.getIn().setHeader(\"samlToken\", assertionElement);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_6 = NL + NL + "\t\t\tprivate org.apache.camel.component.cxf.CxfEndpoint getCxfEndpoint(String uri, boolean isProvider, boolean useAuthorization, boolean usePropagateSamlAP, String... token){" + NL + "\t\t\t\torg.apache.camel.component.cxf.CxfEndpoint cxfEndpoint = (org.apache.camel.component.cxf.CxfEndpoint)endpoint(uri);" + NL;
  protected final String TEXT_7 = NL + "\t\t\t\tif( null != bundleContext ){" + NL + "\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\torg.apache.cxf.Bus bus = cxfEndpoint.getBus();";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tif(isProvider&&token!=null&&\"UsernameToken\".equals(token[0])){" + NL + "\t\t\t\t\t\t\taddUsernameToken(cxfEndpoint,bus, true);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_10 = NL + "\t\t\t\t\t\tif(isProvider&&token!=null &&" + NL + "\t\t\t\t\t\t\t(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "\t\t\t\t\t\t\t\t||org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))){" + NL + "\t\t\t\t\t\t\taddHttpAuth(cxfEndpoint, isProvider, token);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_11 = NL + "\t\t\t\t\tif(token!=null&&\"SAMLToken\".equals(token[0])){" + NL + "\t\t\t\t\t\taddSAMLToken(cxfEndpoint, bus, isProvider, useAuthorization, usePropagateSamlAP, token);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_12 = NL + "\t\t\t\t\tif(token!=null&&\"Registry\".equals(token[0])){" + NL + "\t\t\t\t\t\taddRegistry(cxfEndpoint, bus, isProvider, usePropagateSamlAP, token);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_13 = NL + "\t\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\t\tif(!isProvider&&token!=null&&token.length>=3&&\"UsernameToken\".equals(token[0])){" + NL + "\t\t\t\t\taddUsernameToken(cxfEndpoint, null, false, token[1], token[2]);" + NL + "\t\t\t\t}";
  protected final String TEXT_15 = NL + "\t\t\t\t\tif(!isProvider&&token!=null &&" + NL + "\t\t\t\t\t\t\t(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "\t\t\t\t\t\t\t\t\t||org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))){" + NL + "\t\t\t\t\t\taddHttpAuth(cxfEndpoint, isProvider, token);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_16 = NL + NL + "\t\t\t\treturn cxfEndpoint;" + NL + "\t\t\t}";
  protected final String TEXT_17 = NL + "\t\t\tprivate void addHttpAuth(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, boolean isProvider, final String... userInfo){";
  protected final String TEXT_18 = NL + "\t\t\t\t\tif(!isProvider){" + NL + "\t\t\t\t\t\tMap <String, Object> myProperties = new HashMap<String, Object> ();" + NL + "\t\t\t\t\t\torg.apache.cxf.configuration.security.AuthorizationPolicy authorizationPolicy = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\t\t\t\tauthorizationPolicy.setUserName(userInfo[1]);" + NL + "\t\t\t\t\t\tauthorizationPolicy.setPassword(userInfo[2]);" + NL + "\t\t\t\t\t\tauthorizationPolicy.setAuthorizationType(userInfo[0]);" + NL + "\t\t\t\t\t\tmyProperties.put(org.apache.cxf.configuration.security.AuthorizationPolicy.class.getName(), authorizationPolicy);" + NL + "\t\t\t\t\t\tcxfEndpoint.setProperties(myProperties);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\t\t\tif(isProvider){" + NL + "\t\t\t\t\t\torg.apache.cxf.interceptor.security.JAASLoginInterceptor jaasLoginInterceptor = new org.apache.cxf.interceptor.security.JAASLoginInterceptor();" + NL + "\t\t\t\t\t\tjaasLoginInterceptor.setContextName(\"karaf\");" + NL + "\t\t\t\t\t\tcxfEndpoint.getInInterceptors().add(jaasLoginInterceptor);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_20 = NL + "\t\t\t}";
  protected final String TEXT_21 = NL + "\t\t\tprivate void addUsernameToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint," + NL + "\t\t\t\t\torg.apache.cxf.Bus bus, boolean isProvider, final String... userInfo){";
  protected final String TEXT_22 = NL + "\t\t\t\tif(isProvider){" + NL + "\t\t\t\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\t\t\t\tprops.put(org.apache.wss4j.dom.handler.WSHandlerConstants.ACTION, org.apache.wss4j.dom.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.wss4j.WSS4JInInterceptor wss4jInInterceptor = new org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor();" + NL + "\t\t\t\t\twss4jInInterceptor.setProperties(props);" + NL + "\t\t\t\t\tcxfEndpoint.getInInterceptors().add(wss4jInInterceptor);" + NL + "" + NL + "\t\t\t\t\torg.apache.wss4j.dom.validate.JAASUsernameTokenValidator validator = new org.apache.wss4j.dom.validate.JAASUsernameTokenValidator();" + NL + "\t\t\t\t\tvalidator.setContextName(\"karaf\");" + NL + "\t\t\t\t\tMap<String,Object> map = new HashMap<String, Object>();" + NL + "\t\t\t\t\tmap.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME_TOKEN_VALIDATOR, validator);" + NL + "\t\t\t\t\tcxfEndpoint.setProperties(map);" + NL + "" + NL + "\t\t\t\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\t\t\t\tpolicyReference.setURI(\"org.talend.esb.job.token.policy\");" + NL + "\t\t\t\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\t\t\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\t\t\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\t\t\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\t\t\t\tbus.getFeatures().add(wsPolicyFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_23 = NL + "\t\t\t\tif(!isProvider){" + NL + "\t\t\t\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\t\t\t\tprops.put(org.apache.wss4j.dom.handler.WSHandlerConstants.ACTION, org.apache.wss4j.dom.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "\t\t\t\t\tprops.put(org.apache.wss4j.dom.handler.WSHandlerConstants.USER, userInfo[0]);" + NL + "\t\t\t\t\tprops.put(org.apache.wss4j.dom.handler.WSHandlerConstants.PASSWORD_TYPE, org.apache.wss4j.common.WSS4JConstants.PW_TEXT);" + NL + "\t\t\t\t\tprops.put(org.apache.wss4j.dom.handler.WSHandlerConstants.PW_CALLBACK_REF," + NL + "\t\t\t\t\t    new org.talend.esb.security.saml.WSPasswordCallbackHandler(userInfo[0], userInfo[1]));" + NL + "\t\t\t\t\tcxfEndpoint.getOutInterceptors().add(new org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor(props));" + NL + "\t\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t}";
  protected final String TEXT_25 = NL + NL + "private Map<String, String> clientProperties;" + NL + "" + NL + "private Map<String, String> stsProperties;" + NL + "" + NL + "public void setClientProperties(Map<String, String> clientProperties) {" + NL + "\t\tthis.clientProperties = clientProperties;" + NL + "}" + NL + "" + NL + "public void setStsProperties(Map<String, String> stsProperties) {" + NL + "\t\tthis.stsProperties = stsProperties;" + NL + "}" + NL;
  protected final String TEXT_26 = NL + "org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy consumerSoapHeaderFilter = new org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy(){" + NL + "\tpublic boolean applyFilterToCamelHeaders(String headerName," + NL + "\t\t\tObject headerValue, org.apache.camel.Exchange exchange) {" + NL + "\t\t//filter propagated cxf header" + NL + "\t\tif(org.apache.cxf.headers.Header.HEADER_LIST.equals(headerName)){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t//remove correlationID header, if it's null or empty" + NL + "\t\tif(\"CorrelationID\".equals(headerName)" + NL + "\t\t\t\t&& (headerValue == null || \"\".equals(headerValue.toString()))){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.applyFilterToCamelHeaders(headerName, headerValue, exchange);" + NL + "\t}" + NL + "" + NL + "\tpublic boolean applyFilterToExternalHeaders(String headerName," + NL + "\t\t\tObject headerValue, org.apache.camel.Exchange exchange) {" + NL + "\t\tif(org.apache.cxf.headers.Header.HEADER_LIST.equals(headerName)){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.applyFilterToExternalHeaders(headerName, headerValue, exchange);" + NL + "\t}" + NL + "};";
  protected final String TEXT_27 = NL + "private void addRegistry(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, org.apache.cxf.Bus bus," + NL + "\t\tboolean isProvider, boolean usePropagateSamlAP, final String... token) {";
  protected final String TEXT_28 = NL + NL + "\tif(!isProvider){" + NL + "\t\tif(usePropagateSamlAP && (token[4] == null)){" + NL + "\t\t\tusePropagateSamlAP = false ;" + NL + "\t\t}" + NL + "        Map<String, String> stsProps = new HashMap<String, String>(stsProperties);" + NL + "\t\tfinal org.apache.cxf.ws.security.trust.STSClient stsClient;" + NL + "\t\tif(usePropagateSamlAP) {" + NL + "            stsProps.put(org.apache.cxf.ws.security.SecurityConstants.STS_TOKEN_USERNAME, token[4]);" + NL + "            stsClient= org.talend.esb.security.saml.STSClientUtils.createSTSX509Client(bus, stsProps);" + NL + "\t\t}else {" + NL + "            stsProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME, token[1]);" + NL + "            stsProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD, token[2]);" + NL + "            stsClient= org.talend.esb.security.saml.STSClientUtils.createSTSClient(bus, stsProps);" + NL + "\t\t}" + NL + "\t\tif (token[3]/*Role*/ != null && !(\"\".equals(token[3]))) {" + NL + "            org.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, token[3]);" + NL + "\t\t}" + NL + "" + NL + "\t\tMap<String, Object> clientProps = new HashMap<String, Object>();" + NL + "\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME," + NL + "\t\t\t\ttoken[1]);" + NL + "\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD," + NL + "\t\t\t\ttoken[2]);" + NL + "" + NL + "\t\tclientProps.put(" + NL + "\t\t\t\torg.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "\t\t\t\tstsClient);" + NL + "" + NL + "\t\tfor (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\tclientProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tif(usePropagateSamlAP) {" + NL + "\t\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, token[4]);" + NL + "\t\t\tclientProps" + NL + "\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\tnew org.talend.esb.security.saml.WSPasswordCallbackHandler(token[4], token[2]));" + NL + "\t\t}else {" + NL + "\t\t\tclientProps" + NL + "\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\tnew org.talend.esb.security.saml.WSPasswordCallbackHandler(" + NL + "\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t.get(\"security.signature.password\")));" + NL + "\t\t}" + NL + "\t\tclientProps.put(\"soap.no.validate.parts\", Boolean.TRUE);" + NL + "\t\tclientProps.put(\"use.service.registry\", \"true\");" + NL + "\t\t// set the cxfEndpoint Properties" + NL + "\t\tcxfEndpoint.setProperties(clientProps);" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\tfinal org.apache.camel.component.cxf.CxfEndpointConfigurer cxfEndpointConfigurer = cxfEndpoint.getCxfEndpointConfigurer();" + NL + "\t\tcxfEndpoint.setCxfEndpointConfigurer(new org.apache.camel.component.cxf.CxfEndpointConfigurer() {" + NL + "\t\t\tpublic void configure(org.apache.cxf.frontend.AbstractWSDLBasedEndpointFactory factory) {" + NL + "\t\t\t\tif (cxfEndpointConfigurer != null) {" + NL + "\t\t\t\t\tcxfEndpointConfigurer.configure(factory);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tfactory.setAddress(null);" + NL + "\t\t\t}" + NL + "\t\t\tpublic void configureClient(org.apache.cxf.endpoint.Client client) {" + NL + "\t\t\t\tif (cxfEndpointConfigurer != null) {" + NL + "\t\t\t\t\tcxfEndpointConfigurer.configureClient(client);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic void configureServer(org.apache.cxf.endpoint.Server server) {" + NL + "\t\t\t\tif (cxfEndpointConfigurer != null) {" + NL + "\t\t\t\t\tcxfEndpointConfigurer.configureServer(server);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\torg.apache.cxf.endpoint.ClientLifeCycleManager cLifeCycleManager = bus.getExtension(org.apache.cxf.endpoint.ClientLifeCycleManager.class);" + NL + "\t\tif (cLifeCycleManager != null) {" + NL + "\t\t\tcLifeCycleManager.registerListener(new org.apache.cxf.endpoint.ClientLifeCycleListener() {" + NL + "\t\t\t\tpublic void clientCreated(org.apache.cxf.endpoint.Client client) {" + NL + "\t\t\t\t\tString address = client.getEndpoint().getEndpointInfo().getAddress();" + NL + "\t\t\t\t\tif ((address != null) && address.startsWith(\"locator://\")) {" + NL + "\t\t\t\t\t\tnew org.talend.esb.servicelocator.cxf.LocatorFeature().initialize(client, client.getBus());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void clientDestroyed(org.apache.cxf.endpoint.Client client) {" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_31 = NL + "\tif (isProvider) {" + NL + "\t\tString userName = (String) securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME);" + NL + "\t\tString password = (String) securityProps.get(\"security.signature.password\");" + NL + "\t\tString properties = (String) securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES);" + NL + "" + NL + "\t\torg.apache.wss4j.dom.validate.JAASUsernameTokenValidator jaasUTValidator = new org.apache.wss4j.dom.validate.JAASUsernameTokenValidator();" + NL + "\t\tjaasUTValidator.setContextName(\"karaf\");" + NL + "\t\t// set endpoint properties" + NL + "\t\torg.apache.cxf.interceptor.security.NamePasswordCallbackHandler callbackHandler = new org.apache.cxf.interceptor.security.NamePasswordCallbackHandler(" + NL + "\t\t\t\tuserName, password, \"setPassword\");" + NL + "\t\tMap<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "\t\tendpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, userName);" + NL + "\t\tendpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES, properties);" + NL + "\t\tendpointProps.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER, callbackHandler);" + NL + "\t\tendpointProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME_TOKEN_VALIDATOR, jaasUTValidator);" + NL + "\t\tendpointProps.put(\"use.service.registry\", \"true\");" + NL + "\t\tcxfEndpoint.setProperties(endpointProps);" + NL + "" + NL + "" + NL + "\t}";
  protected final String TEXT_32 = NL + "}";
  protected final String TEXT_33 = NL + "private Map<String, Object> securityProps;" + NL + "" + NL + "public void setSecurityProps(Map<String, Object> securityProps) {" + NL + "\tthis.securityProps = securityProps;" + NL + "}";
  protected final String TEXT_34 = NL + "private org.apache.cxf.interceptor.Interceptor<? extends org.apache.cxf.message.Message> authorizationInterceptor;" + NL + "" + NL + "public void setAuthorizationInterceptor(org.apache.cxf.interceptor.Interceptor<? extends org.apache.cxf.message.Message> authorizationInterceptor) {" + NL + "    this.authorizationInterceptor = authorizationInterceptor;" + NL + "}";
  protected final String TEXT_35 = NL + NL + NL + "private Map<String, String> policies;" + NL + "" + NL + "public void setPolicies(Map<String, String> policies){" + NL + "\tthis.policies = policies;" + NL + "}" + NL + "" + NL + "private org.apache.neethi.Policy loadPolicy(String location, org.apache.cxf.Bus bus) {" + NL + "\tjava.io.InputStream is = null;" + NL + "\ttry {" + NL + "\t\tis = new java.io.FileInputStream(location);" + NL + "\t\treturn bus.getExtension(org.apache.cxf.ws.policy.PolicyBuilder.class).getPolicy(is);" + NL + "\t} catch (Exception e) {" + NL + "\t\tthrow new RuntimeException(\"Cannot load policy\", e);" + NL + "\t} finally {" + NL + "\t\tif (null != is) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tis.close();" + NL + "\t\t\t} catch (java.io.IOException e) {" + NL + "\t\t\t\t// just ignore" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "public void registerPolicies(org.apache.cxf.Bus bus) {" + NL + "\tif(policies != null){" + NL + "\t\torg.apache.neethi.PolicyRegistry policyRegistry =" + NL + "\t\t\t\tbus.getExtension(org.apache.cxf.ws.policy.PolicyEngine.class).getRegistry();" + NL + "\t\tpolicyRegistry.register(\"org.talend.esb.job.token.policy\"," + NL + "\t\t\t\tloadPolicy(policies.get(\"policy.username\"), bus));" + NL + "\t\tpolicyRegistry.register(\"org.talend.esb.job.saml.policy\"," + NL + "\t\t\t\tloadPolicy(policies.get(\"policy.saml\"), bus));" + NL + "" + NL + "\t\tpolicyRegistry.register(\"org.talend.esb.job.saml.authz.policy\"," + NL + "\t\t\t\tloadPolicy(policies.get(\"policy.saml.authz\"), bus));" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_36 = NL + NL + "private void addSAMLToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, org.apache.cxf.Bus bus," + NL + "\t\tboolean isProvider, boolean useAuthorization, boolean usePropagateSamlAP, String... token) {";
  protected final String TEXT_37 = NL + "\tif (!isProvider) {" + NL + "        Map<String, String> stsProps = new HashMap<String, String>(stsProperties);" + NL + "        final org.apache.cxf.ws.security.trust.STSClient stsClient;" + NL + "        if(usePropagateSamlAP) {" + NL + "            stsProps.put(org.apache.cxf.ws.security.SecurityConstants.STS_TOKEN_USERNAME, token[4]);" + NL + "            stsClient= org.talend.esb.security.saml.STSClientUtils.createSTSX509Client(bus, stsProps);" + NL + "        }else {" + NL + "            stsProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME, token[1]);" + NL + "            stsProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD, token[2]);" + NL + "            stsClient= org.talend.esb.security.saml.STSClientUtils.createSTSClient(bus, stsProps);" + NL + "        }";
  protected final String TEXT_38 = NL + "\t\tif (token[3] != null && !(\"\".equals(token[3]))) {" + NL + "\t\t\torg.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, token[3]);" + NL + "\t\t}";
  protected final String TEXT_39 = NL + "\t\tMap<String, Object> clientProps = new HashMap<String, Object>();" + NL + "\t\tclientProps.put(" + NL + "\t\t\t\torg.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "\t\t\t\tstsClient);" + NL + "" + NL + "\t\tfor (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\tclientProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif(usePropagateSamlAP) {" + NL + "\t\t\tclientProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, token[4]);" + NL + "\t\t\tclientProps" + NL + "\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\tnew org.talend.esb.security.saml.WSPasswordCallbackHandler(token[4], token[2]));" + NL + "\t\t}else {" + NL + "\t\t\tclientProps" + NL + "\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\tnew org.talend.esb.security.saml.WSPasswordCallbackHandler(" + NL + "\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t.get(\"security.signature.password\")));" + NL + "\t\t}" + NL + "\t\t// set the cxfEndpoint Properties" + NL + "\t\tcxfEndpoint.setProperties(clientProps);" + NL + "" + NL + "\t\t// add policy" + NL + "\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\tif(useAuthorization){" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.authz.policy\");" + NL + "\t\t}else{" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.policy\");" + NL + "\t\t}" + NL + "\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\tcxfEndpoint.getFeatures().add(wsPolicyFeature);" + NL + "\t\t// register bus with policy" + NL + "\t\tregisterPolicies(bus);" + NL + "\t}";
  protected final String TEXT_40 = NL + "if (isProvider) {" + NL + "\t\t// get saml properties" + NL + "\t\tString userName = (String) securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME);" + NL + "\t\tString password = (String) securityProps.get(\"security.signature.password\");" + NL + "\t\tString properties = (String) securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES);" + NL + "\t\t// add in intercept" + NL + "\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\tprops.put(" + NL + "\t\t\t\torg.apache.wss4j.dom.handler.WSHandlerConstants.ACTION," + NL + "\t\t\t\torg.apache.wss4j.dom.handler.WSHandlerConstants.ENCRYPT+\" \"" + NL + "\t\t\t\t\t\t+org.apache.wss4j.dom.handler.WSHandlerConstants.SAML_TOKEN_SIGNED+\" \"" + NL + "\t\t\t\t\t\t+org.apache.wss4j.dom.handler.WSHandlerConstants.SIGNATURE);" + NL + "\t\tprops.put(" + NL + "\t\t\t\torg.apache.wss4j.dom.handler.WSHandlerConstants.SIG_PROP_FILE," + NL + "\t\t\t\tproperties);" + NL + "" + NL + "        org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor wss4jInInterceptor =" + NL + "            new org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor();" + NL + "        wss4jInInterceptor.setProperties(props);" + NL + "        cxfEndpoint.getInInterceptors().add(wss4jInInterceptor);" + NL + "" + NL + "\t\t// set endpoint properties" + NL + "\t\torg.apache.cxf.interceptor.security.NamePasswordCallbackHandler callbackHandler = new org.apache.cxf.interceptor.security.NamePasswordCallbackHandler(" + NL + "\t\t\t\tuserName, password, \"setPassword\");" + NL + "\t\tMap<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "\t\tendpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, userName);" + NL + "\t\tendpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES, properties);" + NL + "\t\tendpointProps.put(org.apache.cxf.rt.security.SecurityConstants.CALLBACK_HANDLER, callbackHandler);" + NL + "\t\tendpointProps.put(\"use.service.registry\", \"false\");" + NL + "\t\tcxfEndpoint.setProperties(endpointProps);" + NL + "\t\t// add policy" + NL + "\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\tif(!useAuthorization){" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.policy\");" + NL + "\t\t}else{" + NL + "\t\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.authz.policy\");" + NL + "\t\t}" + NL + "\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\tcxfEndpoint.getFeatures().add(wsPolicyFeature);" + NL + "\t\t// register policy on bus" + NL + "\t\tregisterPolicies(bus);" + NL + "}";
  protected final String TEXT_41 = NL + "}";
  protected final String TEXT_42 = NL + "\t\t\t/**" + NL + "\t\t\t* please initial uri map" + NL + "\t\t\t*/" + NL + "\t\t\tpublic void configure() throws java.lang.Exception {";
  protected final String TEXT_43 = NL + "\t\t\t\t";
  protected final String TEXT_44 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_48 = " = ";
  protected final String TEXT_49 = "; ";
  protected final String TEXT_50 = NL + "\t\t\t\t// CXF endpoint for ";
  protected final String TEXT_51 = NL + "\t\t\t\torg.apache.camel.component.cxf.CxfEndpoint ";
  protected final String TEXT_52 = " = getCxfEndpoint(";
  protected final String TEXT_53 = ", ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t,";
  protected final String TEXT_58 = ",decryptedPassword_";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t);";
  protected final String TEXT_62 = NL + "\t\t\t\t";
  protected final String TEXT_63 = ".setCxfBinding(new CXFConsumerBinding(";
  protected final String TEXT_64 = "));";
  protected final String TEXT_65 = NL + "                final String correlationId_";
  protected final String TEXT_66 = " = ";
  protected final String TEXT_67 = ";" + NL + "                if (null != correlationId_";
  protected final String TEXT_68 = " && correlationId_";
  protected final String TEXT_69 = ".length() > 0) {" + NL + "                    correlationIDCallbackHandler_";
  protected final String TEXT_70 = ".setCorrelationId(correlationId_";
  protected final String TEXT_71 = ");" + NL + "                    java.util.Map<String, Object> properties = new java.util.HashMap<String, Object>();" + NL + "                    properties.put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, " + NL + "                        correlationIDCallbackHandler_";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "                    ";
  protected final String TEXT_74 = ".setProperties(properties);" + NL + "                }";
  protected final String TEXT_75 = NL + "                    ";
  protected final String TEXT_76 = ".getFeatures().add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_77 = NL + "                    ";
  protected final String TEXT_78 = ".setAddress(\"locator://cCXF\");";
  protected final String TEXT_79 = NL + "\t\t\t\t// Add Service Locator Service to ";
  protected final String TEXT_80 = NL + "\t\t\t\torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_";
  protected final String TEXT_81 = " = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "\t\t\t\tif (null == bundleContext) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\tjava.util.Map<String, String> slCustomProps_";
  protected final String TEXT_84 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\tslCustomProps_";
  protected final String TEXT_86 = ".put(";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\tlocatorFeature_";
  protected final String TEXT_91 = ".setAvailableEndpointProperties(slCustomProps_";
  protected final String TEXT_92 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\tlocatorFeature_";
  protected final String TEXT_94 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_95 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\t";
  protected final String TEXT_97 = NL + NL + "\t\t\t\t";
  protected final String TEXT_98 = ".getFeatures().add(locatorFeature_";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "\t\t\t\t// Add Service Activity Monitor Service to ";
  protected final String TEXT_101 = NL + "\t\t\t\tif (eventFeature != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_102 = ".getFeatures().add(eventFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_103 = NL + "\t\t\t";
  protected final String TEXT_104 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_105 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = "; ";
  protected final String TEXT_110 = NL + "\t\t\t" + NL + "\t\t\torg.apache.camel.component.file.remote.RemoteFileEndpoint<?> ";
  protected final String TEXT_111 = " = getFtpEndpoint(";
  protected final String TEXT_112 = ", ";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ", ";
  protected final String TEXT_115 = ", decryptedPassword_";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\t\t\t";
  protected final String TEXT_119 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_120 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = "; ";
  protected final String TEXT_125 = NL + "\t\t\t" + NL + "\t\t\torg.apache.camel.component.mail.MailEndpoint ";
  protected final String TEXT_126 = " = getMailEndpoint(";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ", decryptedPassword_";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ", ";
  protected final String TEXT_131 = ", ";
  protected final String TEXT_132 = ", ";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\torg.apache.camel.spi.AggregationRepository repo_";
  protected final String TEXT_136 = " = new ";
  protected final String TEXT_137 = ";";
  protected final String TEXT_138 = NL + "\t\t\t\t\t\torg.apache.camel.spi.RecoverableAggregationRepository repo_";
  protected final String TEXT_139 = " = new ";
  protected final String TEXT_140 = ";";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_142 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_143 = ".setMaximumRedeliveries(";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_145 = ".setDeadLetterUri(";
  protected final String TEXT_146 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_147 = ".setRecoveryInterval(";
  protected final String TEXT_148 = ");";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_150 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_151 = "\", ";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_154 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_155 = "\");";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_157 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_158 = ".setMaximumRedeliveries(";
  protected final String TEXT_159 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_160 = ".setDeadLetterUri(";
  protected final String TEXT_161 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_162 = ".setRecoveryInterval(";
  protected final String TEXT_163 = ");";
  protected final String TEXT_164 = NL + "\t\t\t\tMap<String, String> ";
  protected final String TEXT_165 = "NSMap = new HashMap<String, String>();" + NL + "\t\t\t\t{";
  protected final String TEXT_166 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_167 = "NSMap.put(";
  protected final String TEXT_168 = ", ";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\t\t\t\t}";
  protected final String TEXT_171 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_172 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_173 = NL + "\t\t\t\t";
  protected final String TEXT_174 = "NSMap.put(";
  protected final String TEXT_175 = ", ";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + "\t\t}";
  protected final String TEXT_178 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_179 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_180 = NL + "\t\t\t\t";
  protected final String TEXT_181 = "NSMap.put(";
  protected final String TEXT_182 = ", ";
  protected final String TEXT_183 = ");";
  protected final String TEXT_184 = NL + "\t\t}";
  protected final String TEXT_185 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_186 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_187 = NL + "\t\t\t\t";
  protected final String TEXT_188 = "NSMap.put(";
  protected final String TEXT_189 = ", ";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + "\t\t}";
  protected final String TEXT_192 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_193 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_194 = NL + "\t\t\t\t";
  protected final String TEXT_195 = "NSMap.put(";
  protected final String TEXT_196 = ", ";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "\t\t}";
  protected final String TEXT_199 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_200 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_201 = NL + "\t\t\t\t";
  protected final String TEXT_202 = "NSMap.put(";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = ");";
  protected final String TEXT_205 = NL + "\t\t}";
  protected final String TEXT_206 = NL + "\t\torg.talend.camel.TalendEndpoint endpoint_";
  protected final String TEXT_207 = " =" + NL + "\t\t    (org.talend.camel.TalendEndpoint) endpoint(\"talend:\"+ ";
  protected final String TEXT_208 = "+ \"?context=\" + ";
  protected final String TEXT_209 = "+\"&propagateHeader=";
  protected final String TEXT_210 = "\");";
  protected final String TEXT_211 = NL + "\t\t\torg.talend.camel.TalendEndpoint endpoint_";
  protected final String TEXT_212 = " =" + NL + "\t\t\t    (org.talend.camel.TalendEndpoint) endpoint(\"talend:\"+\"";
  protected final String TEXT_213 = "\"+\"?context=\"+";
  protected final String TEXT_214 = "+\"&propagateHeader=";
  protected final String TEXT_215 = "\");";
  protected final String TEXT_216 = NL + "\t\t\torg.talend.camel.TalendEndpoint endpoint_";
  protected final String TEXT_217 = " =" + NL + "\t\t\t    (org.talend.camel.TalendEndpoint) endpoint(\"talend:\"+\"";
  protected final String TEXT_218 = "\"+\"?context=\"+\"";
  protected final String TEXT_219 = "&propagateHeader=";
  protected final String TEXT_220 = "\");";
  protected final String TEXT_221 = NL + "{" + NL + "\t\tMap <String, String> propertiesMap = new HashMap<String, String>();";
  protected final String TEXT_222 = NL + "\t\t\t\tpropertiesMap.put(";
  protected final String TEXT_223 = ", propertyToString(";
  protected final String TEXT_224 = "));";
  protected final String TEXT_225 = NL + "\t\tendpoint_";
  protected final String TEXT_226 = ".setEndpointProperties(propertiesMap);" + NL + "}";
  protected final String TEXT_227 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

/*
	boolean startable = false;
	for (INode node : (List< ? extends INode>)process.getGraphicalNodes()) {
		Object value = node.getPropertyValue("STARTABLE");
		startable = value == null? false:(Boolean)value;
		if(startable){
			break;
		}
	}
*/
	boolean stats = codeGenArgument.isStatistics();


    stringBuffer.append(TEXT_1);
    
			List<? extends INode> cMailNodes = process.getNodesOfType("cMail");
			if(cMailNodes.size() > 0){

    stringBuffer.append(TEXT_2);
    
			}

			List<? extends INode> cFtpNodes = process.getNodesOfType("cFtp");
			if(cFtpNodes.size() > 0){
			// for fix [TESB-15654], Set custom server port for cFTP

    stringBuffer.append(TEXT_3);
    
			}

			boolean hasCXFSamlTokenProvider = false;
			boolean hasCXFSamlTokenConsumer = false;
			boolean hasCXFSamlTokenAuthorizationConsumer = false;
            boolean hasCXFSamlTokenAuthorizationProvider = false;
			boolean hasCXFUsernameTokenProvider = false;
			boolean hasCXFUsernameTokenConsumer = false;
			boolean hasCXFHTTPAuthConsumer = false;
			boolean hasCXFHTTPAuthProvider = false;
			boolean hasCXFComponentConsumer = false;
			boolean hasCXFRegistryProvider = false;
			boolean hasCXFRegistryConsumer = false;
			boolean hasCXFSAMLPropagateConsumer = false;
			boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();

            List<INode> cxfNodes = new ArrayList<INode>();
            cxfNodes.addAll(process.getNodesOfType("cCXF"));
			boolean hasCXFComponent = !cxfNodes.isEmpty();
			cxfNodes.addAll(process.getNodesOfType("cCXFRS"));
			for(INode n: cxfNodes) {
			    boolean isProvider = n.getIncomingConnections().isEmpty();
                hasCXFComponentConsumer |= !isProvider;

				String useRegistry = "false";
				if(isStudioEEVersion){
					useRegistry = ElementParameterParser.getValue(n, "__ENABLE_REGISTRY__");
				}
				String useSecurity = ElementParameterParser.getValue(n, "__ENABLE_SECURITY__");
				String formatType = ElementParameterParser.getValue(n, "__DATAFORMAT__");
				if("RAW".equals(formatType) || "CXF_MESSAGE".equals(formatType)){
					useRegistry = "false";
					useSecurity = "false";
				}
				String securityType = ElementParameterParser.getValue(n, "__SECURITY_TYPE__");

				if("true".equals(useRegistry)){
					useSecurity = "false";
					if (isProvider) {
						hasCXFRegistryProvider = true;
					} else {
						hasCXFRegistryConsumer = true;
						if(!hasCXFSAMLPropagateConsumer && Boolean.parseBoolean(ElementParameterParser.getValue(n, "__USE_PROPAGATE_CREDENTIAL__"))){
							hasCXFSAMLPropagateConsumer = true;
						}
					}
				}
				if("true".equals(useSecurity)){
					if("SAML".equals(securityType) && (!hasCXFSamlTokenProvider || !hasCXFSamlTokenConsumer || !hasCXFSAMLPropagateConsumer)){
						if (isProvider) {
							hasCXFSamlTokenProvider = true;
                            if(!hasCXFSamlTokenAuthorizationProvider && isStudioEEVersion){
                                if("true".equals(ElementParameterParser.getValue(n, "__USE_AUTHORIZATION__"))){
                                    hasCXFSamlTokenAuthorizationProvider = true;
                                }
                            }
						} else {
							hasCXFSamlTokenConsumer = true;
							if(!hasCXFSamlTokenAuthorizationConsumer && isStudioEEVersion){
								if("true".equals(ElementParameterParser.getValue(n, "__USE_AUTHORIZATION__"))){
									hasCXFSamlTokenAuthorizationConsumer = true;
								}
							}
							if(!hasCXFSAMLPropagateConsumer){
								String samlSecurityType = ElementParameterParser.getValue(n, "__SAML_SECURITY_TYPES__");
								if("PROPAGATE_UP".equals(samlSecurityType) || "PROPAGATE_AP".equals(samlSecurityType)){
									hasCXFSAMLPropagateConsumer = true;
								}
							}
						}
					}else if("USER".equals(securityType) && (!hasCXFUsernameTokenProvider || !hasCXFUsernameTokenConsumer)){
						if(isProvider){
							hasCXFUsernameTokenProvider = true;
						}else{
							hasCXFUsernameTokenConsumer = true;
						}
					}else if(("BASIC".equals(securityType)||"DIGEST".equals(securityType)) && (!hasCXFHTTPAuthProvider || !hasCXFHTTPAuthConsumer)){
						if(isProvider){
							hasCXFHTTPAuthProvider = true;
						}else{
							hasCXFHTTPAuthConsumer = true;
						}
					}
				}
			}

		if(hasCXFSAMLPropagateConsumer){

    stringBuffer.append(TEXT_4);
    		}
		if(hasCXFRegistryProvider || hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_5);
    
			}


			if(hasCXFComponent){

    stringBuffer.append(TEXT_6);
    if(hasCXFUsernameTokenProvider || hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer || hasCXFHTTPAuthProvider || hasCXFRegistryProvider || hasCXFRegistryConsumer){
    stringBuffer.append(TEXT_7);
    if(hasCXFUsernameTokenProvider || hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer || hasCXFRegistryProvider || hasCXFRegistryConsumer){
    stringBuffer.append(TEXT_8);
    
					}
					if(hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_9);
    
					}
					if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_10);
    
					}
					if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer){


    stringBuffer.append(TEXT_11);
    					}
					if(hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    
}
				if(hasCXFUsernameTokenConsumer){

    stringBuffer.append(TEXT_14);
    
				}
				if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_15);
    
				}

    stringBuffer.append(TEXT_16);
    
			if(hasCXFHTTPAuthConsumer || hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_17);
    
				if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_18);
    
				}
				if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_19);
    
				}

    stringBuffer.append(TEXT_20);
    
			}
			if(hasCXFUsernameTokenConsumer || hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_21);
    if(hasCXFUsernameTokenProvider){
    stringBuffer.append(TEXT_22);
    
}
if(hasCXFUsernameTokenConsumer){

    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
			}
			}
if(hasCXFSamlTokenConsumer || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_25);
    
}

if(hasCXFComponentConsumer){

    stringBuffer.append(TEXT_26);
    
}
if(hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_27);
    if(hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_28);
    //for fix [TESB-12172], set default address to null to avoid override after wsdl from registry initialized. 
		
    stringBuffer.append(TEXT_29);
    //for fix [TESB-12172], add locator feature when necessary. 
		
    stringBuffer.append(TEXT_30);
    
}
if(hasCXFRegistryProvider){

    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    
}

if (hasCXFSamlTokenProvider || hasCXFRegistryProvider) {

    stringBuffer.append(TEXT_33);
    
}

if (hasCXFSamlTokenAuthorizationProvider && !hasCXFComponent) {

    stringBuffer.append(TEXT_34);
    
}

if(hasCXFComponent && (hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer
	||hasCXFRegistryProvider || hasCXFRegistryConsumer)){

    stringBuffer.append(TEXT_35);
    
if(hasCXFSamlTokenConsumer || hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_36);
    
if(hasCXFSamlTokenConsumer){

    stringBuffer.append(TEXT_37);
    if(hasCXFSamlTokenAuthorizationConsumer){
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    
}
if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_40);
    
}//end if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_41);
    
}//end if(hasCXFSamlTokenConsumer || hasCXFSamlTokenProvider){
}//end if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer
//||hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_42);
    
	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGraphicalNodes();
	for (INode node : processNodes) {
			if (!node.isActivate()) {
				continue;
			}
			String nodeComponentName = node.getComponent().getName();
	if("cCXF".equals(nodeComponentName)){
			IElementParameter param = node.getElementParameter("LABEL");
			String cid = node.getUniqueName();
			// http://jira.talendforge.org/browse/TESB-5241
			/*
			 * change to use label + unique to make it unique but readable
			 */
//			if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
//				cid = (String)param.getValue()+"_"+cid;
//			}
			String endpointVar = "endpoint_" + node.getUniqueName();
			String uriRef = "uriMap.get(\"" + cid + "\")";
			String formatType = ElementParameterParser.getValue(node, "__DATAFORMAT__");

			boolean useRegistry = false;
			boolean useSecurity = false;
			if(!"RAW".equals(formatType) && !"CXF_MESSAGE".equals(formatType)){
				if(isStudioEEVersion){
					useRegistry = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__"));
				}
				if(!useRegistry){
					useSecurity = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"));
				}
			}

			String securityType = ElementParameterParser.getValue(node, "__SECURITY_TYPE__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
			String alias = ElementParameterParser.getValue(node, "__ALIASNAME__").trim();
			boolean isProvider = node.getIncomingConnections().isEmpty();
			boolean isUseAuthorization = false;
			String securityToken = "(String[])null";
			boolean isUsePropagateSamlUP = false;
			boolean isUsePropagateSamlAP = false;
			if(useRegistry){
				securityToken = "\"Registry\"";
					String usePropagate = ElementParameterParser.getValue(node, "__USE_PROPAGATE_CREDENTIAL__");
					if("true".equals(usePropagate)){
						if(alias == null || alias.matches("\"?\\s*\"?")) {
							//no alias.
							isUsePropagateSamlUP = true;
						}else {
							isUsePropagateSamlUP = false;
						}
						isUsePropagateSamlAP = !isUsePropagateSamlUP;
					}
			}else if(useSecurity){
				if("USER".equals(securityType)){
					securityToken = "\"UsernameToken\"";
				}else if("SAML".equals(securityType)){
					securityToken = "\"SAMLToken\"";
					String samlSecurityType = ElementParameterParser.getValue(node, "__SAML_SECURITY_TYPES__");
					if("PROPAGATE_UP".equals(samlSecurityType)) {
							isUsePropagateSamlUP = true;
					}else if ("PROPAGATE_AP".equals(samlSecurityType)) {
						isUsePropagateSamlAP = true;
						username = "null";
					}
					if(isStudioEEVersion){
						isUseAuthorization = "true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"));
					}
				}else if("BASIC".equals(securityType)){
					securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC";
				}else if("DIGEST".equals(securityType)){
					securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST";
				}
			}
			String roleName = "\"\"";
			if(!isProvider && (useRegistry || isUseAuthorization)) {
				roleName = ElementParameterParser.getValue(node, "__ROLE_NAME__");
				if(null == roleName || "".equals(roleName)){
					roleName = "\"\"";
				}
			}
			
			if((useSecurity || useRegistry) && !isProvider) {
				String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_43);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    } else {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_49);
    }
    
			}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(isProvider);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(isUseAuthorization);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(isUsePropagateSamlAP);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(securityToken);
    
				if((useSecurity || useRegistry) && !isProvider){

    stringBuffer.append(TEXT_57);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(roleName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(alias);
    
				}

    stringBuffer.append(TEXT_61);
    

			if((isUsePropagateSamlUP || isUsePropagateSamlAP) && !isProvider){

    stringBuffer.append(TEXT_62);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_64);
    
			}
			String useSL = ElementParameterParser.getValue(node, "__ENABLE_SL__");
			String useSAM = ElementParameterParser.getValue(node, "__ENABLE_SAM__");
			String useCorrelation = ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__");
			if("RAW".equals(formatType)){
				useCorrelation = "false";
			}

			if ("true".equals(useCorrelation) || useRegistry) {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_74);
     if (!useRegistry) { 
    stringBuffer.append(TEXT_75);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_76);
     } 
    			}
			if ("true".equals(useSL) && (isProvider || !useRegistry)) {
                if (!isProvider) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_78);
    
                }
				List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");

    stringBuffer.append(TEXT_79);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_82);
     if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_88);
     } 
    stringBuffer.append(TEXT_89);
     if (isProvider) { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
     } else { 
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
     } 
    stringBuffer.append(TEXT_96);
     } 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    
			}
			//http://jira.talendforge.org/browse/TESB-3850
			// !"true".equals(useRegistry) - https://jira.talendforge.org/browse/TESB-10725

			if ("true".equals(useSAM) && !"RAW".equals(formatType) && !useRegistry) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_102);
    
			}
	}else if("cFtp".equals(nodeComponentName)){
			String ftpEndpointVar = "ftp_" + node.getUniqueName();
			String cid = node.getUniqueName();
//			IElementParameter labelParam = node.getElementParameter("LABEL");
//			if(labelParam != null && !"__UNIQUE_NAME__".equals(labelParam.getValue())){
//				cid = (String)labelParam.getValue()+"_"+cid;
//			}
			String uriRef = "uriMap.get(\"" + cid + "\")";

			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			if("".trim().equals(userName)){
				userName = null;
			}
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			if("".trim().equals(password)){
				password = null;
			}
			String ftpServer = ElementParameterParser.getValue(node, "__SERVER__");
			String ftpPort = TalendQuoteUtils.removeQuotes(ElementParameterParser.getValue(node, "__PORT__"));
			String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
			if("".trim().equals(directory)){
				directory = null;
			}
			
			String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_103);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_106);
    } else {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ftpEndpointVar);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(ftpServer);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(ftpPort);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_117);
    

	}else if("cMail".equals(nodeComponentName)){
			String mailEndpointVar = "mail_" + node.getUniqueName();
			String cid = node.getUniqueName();
//			IElementParameter labelParam = node.getElementParameter("LABEL");
//			if(labelParam != null && !"__UNIQUE_NAME__".equals(labelParam.getValue())){
//				cid = (String)labelParam.getValue()+"_"+cid;
//			}
			String uriRef = "uriMap.get(\"" + cid + "\")";

			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
			String from = ElementParameterParser.getValue(node, "__FROM__");
			String to = ElementParameterParser.getValue(node, "__TO__");
			String cc = ElementParameterParser.getValue(node, "__CC__");
			String bcc = ElementParameterParser.getValue(node, "__BCC__");
			String passwordFieldName = "__PASSWORD__";

    stringBuffer.append(TEXT_118);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_121);
    } else {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(mailEndpointVar);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(subject);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cc);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(bcc);
    stringBuffer.append(TEXT_134);
    	}else if("cAggregate".equals(nodeComponentName)){
				boolean usePersistence = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENCE__"));
				String repository = ElementParameterParser.getValue(node, "__REPOSITORY__");
				if (usePersistence) {
					boolean useRecovery = "true".equals(ElementParameterParser.getValue(node, "__USE_RECOVERY__"));
					String recoveryInterval = ElementParameterParser.getValue(node, "__RECOVERY_INTERVAL__");
					String deadLetterUri = ElementParameterParser.getValue(node, "__DEAD_LETTER_URI__");
					String maximumRedeliveries = ElementParameterParser.getValue(node, "__MAXIMUM_REDELIVERIES__");

					if ("AGGREGATION".equals(repository)) {

    stringBuffer.append(TEXT_135);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_137);
    
					} else if ("RECOVERABLE".equals(repository)) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_140);
    
						if (useRecovery) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_148);
    
						}
					} else if ("HAWTDB".equals(repository)) {
						boolean usePersistentFile = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENT_FILE__"));
						String persistentFile = ElementParameterParser.getValue(node, "__PERSISTENT_FILENAME__");
						if (usePersistentFile) {

    stringBuffer.append(TEXT_149);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(persistentFile);
    stringBuffer.append(TEXT_152);
    
						} else {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_155);
    
						}
						if (useRecovery) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_163);
    
						}
					}
				}

				String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
				String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
				List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");
				if("xpath".equals(language)&&"true".equals(useNamespaces)){
					String cid = node.getUniqueName();


    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    
					for(Map<String, String> m: namespaceValues){
						String pre = m.get("PREFIX");
						String uri = m.get("URI");

    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_169);
    
					}

    stringBuffer.append(TEXT_170);
    
				}
	}else if("cLoop".equals(nodeComponentName)){
		String type = ElementParameterParser.getValue(node, "__LOOP_TYPE__");
		if(!"EXPRESSION_TYPE".equals(type)){
			continue;
		}
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_176);
    
			}

    stringBuffer.append(TEXT_177);
    

	}else if("cMessageFilter".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_183);
    
			}

    stringBuffer.append(TEXT_184);
    
	}else if("cRecipientList".equals(nodeComponentName)||"cSplitter".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_190);
    
			}

    stringBuffer.append(TEXT_191);
    
	}else if("cSetBody".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_197);
    
			}

    stringBuffer.append(TEXT_198);
    
	}else if("cSetHeader".equals(nodeComponentName)){
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_204);
    
			}

    stringBuffer.append(TEXT_205);
    
	}else if("cTalendJob".equals(nodeComponentName)){
	List< ? extends IConnection> conns = node.getIncomingConnections();
	String cid = node.getUniqueName();
	List<Map<String, String>> contextParams = null;
	if(conns.size()>0) {
		String useJar = ElementParameterParser.getValue(node, "__FROM_EXTERNAL_JAR__");
		// when propagateHeader parameter will be removed the https://github.com/Talend/tesb-rt-se/blob/master/camel-talendjob/src/main/java/org/talend/camel/TalendProducer.java
		// have to be changed - remove populateTalendContextParamsWithCamelHeaders(exchange, args);
		String propagateHeader = ElementParameterParser.getValue(node, "__PROPAGATE_HEADER__");
		if("true".equals(useJar)){
			String typeName = ElementParameterParser.getValue(node, "__JOB__");
			String context = ElementParameterParser.getValue(node, "__CONTEXT__");
			contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXTERNAL_JAR_CONTEXTPARAMS__");

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_210);
    
		}else{
			String typeName = "";
			contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
			String context = (String) node.getElementParameter("PROCESS_TYPE_CONTEXT").getValue();
			String id = (String) node.getElementParameter("PROCESS_TYPE_PROCESS").getValue();
			if(id != null){
				String useSelectedContext = ElementParameterParser.getValue(node, "__USE_SELECTED_CONTEXT__");
				String useRouteContext = ElementParameterParser.getValue(node, "__USE_ROUTE_CONTEXT__");
				String useJobContext = ElementParameterParser.getValue(node, "__USE_JOB_CONTEXT__");
				if("true".equals(useRouteContext)){
					// TESB-13614
					// we can't define context during codegeneration in this case, because
					// context will provided to the job before execution
					context = "NOT_DEFINED";					

				}else if("true".equals(useJobContext)){
					context = ElementParameterParser.getProcessSelectedContext(id);
				}

				String jobName = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("SELECTED_JOB_NAME"));
//				String jobName = (String) node.getElementParameter("SELECTED_JOB_NAME").getValue();
				String jobVersion = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("PROCESS_TYPE_VERSION"));
				String jobFolderName = JavaResourcesHelper.getJobFolderName(jobName, jobVersion);
				typeName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName + "." + jobName;
			}
			
			if("NOT_DEFINED".equals(context)){
        		String executionContextVariable = "contextStr";

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(executionContextVariable);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_215);
    			
			} else {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_220);
    			
			}			
						
		}
		int contextParamsSize = contextParams.size();
		if(contextParamsSize > 0){

    stringBuffer.append(TEXT_221);
    
		for (int i=0; i<contextParamsSize; i++) {
				Map<String, String> contextParam = contextParams.get(i);
				String paramName;
				String paramValue;
				if("true".equals(useJar)){
					paramName = contextParam.get("EXTERNAL_JAR_PARAM_NAME_COLUMN");
					paramValue = contextParam.get("EXTERNAL_JAR_PARAM_VALUE_COLUMN");

				} else {
					paramName = "\"" + contextParam.get("PARAM_NAME_COLUMN") + "\"";
					paramValue = contextParam.get("PARAM_VALUE_COLUMN");
				}

    stringBuffer.append(TEXT_222);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(paramValue);
    stringBuffer.append(TEXT_224);
    
		}

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
	}
	}
	}
}

    stringBuffer.append(TEXT_227);
    return stringBuffer.toString();
  }
}
