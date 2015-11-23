package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.core.model.utils.JavaResourcesHelper;
import java.util.Vector;
import java.util.List;
import java.util.Map;

public class Camel_footerJava
{
  protected static String nl;
  public static synchronized Camel_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_footerJava result = new Camel_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t}" + NL + "\t\tprivate org.apache.camel.main.Main main = null;" + NL + "\t\tprivate void run() throws java.lang.Exception{" + NL + "" + NL + "\t\t\tmain = new org.apache.camel.main.Main(){" + NL + "" + NL + "\t\tprotected Map<String, CamelContext> getCamelContextMap() {" + NL + "\t\t\tfinal org.apache.camel.impl.DefaultCamelContext camelContext;" + NL + "\t\t\tif(bundleContext != null){" + NL + "\t\t\t\torg.apache.camel.spring.SpringCamelContext.setNoStart(true);" + NL + "\t\t\t\torg.apache.camel.osgi.CamelContextFactoryBean contextFactory = new org.apache.camel.osgi.CamelContextFactoryBean();" + NL + "\t\t\t\tcontextFactory.setId(\"";
  protected final String TEXT_2 = "-ctx\");" + NL + "\t\t\t\torg.springframework.osgi.context.support.OsgiBundleXmlApplicationContext appContext = new org.springframework.osgi.context.support.OsgiBundleXmlApplicationContext(" + NL + "\t\t\t\t\t\tnew String[]{\"META-INF/spring/";
  protected final String TEXT_3 = ".xml\"});" + NL + "\t\t\t\tappContext.setBundleContext(bundleContext);" + NL + "\t\t\t\tappContext.refresh();" + NL + "\t\t\t\tcontextFactory.setApplicationContext(appContext);" + NL + "\t\t\t\tcontextFactory.setBundleContext(bundleContext);" + NL + "\t\t\t\tcamelContext = contextFactory.getContext(true);" + NL + "\t\t\t\tbundleContext.registerService(CamelContext.class.getName(), camelContext, null);" + NL + "\t\t\t} else {" + NL + "\t\t\t\torg.apache.camel.osgi.SpringCamelContextFactory contextFactory = new org.apache.camel.osgi.SpringCamelContextFactory();" + NL + "\t\t\t\tcontextFactory.setApplicationContext(new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/spring/";
  protected final String TEXT_4 = ".xml\"));" + NL + "\t\t\t\tcamelContext = contextFactory.createContext();" + NL + "\t\t\t\tcamelContext.setName(\"";
  protected final String TEXT_5 = "-ctx\");" + NL + "\t\t\t}" + NL + "\t\t\tfinal org.apache.camel.impl.CompositeRegistry compositeRegistry =" + NL + "\t\t\t\tnew org.apache.camel.impl.CompositeRegistry();" + NL + "\t\t\tcompositeRegistry.addRegistry(camelContext.getRegistry());" + NL + "\t\t\tcompositeRegistry.addRegistry(registry);" + NL + "\t\t\tcamelContext.setRegistry(compositeRegistry);";
  protected final String TEXT_6 = NL + "                    camelContext.setUseMDCLogging(true);";
  protected final String TEXT_7 = NL + "\t\t\t    ";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t\t\t\t\tbind(\"CXF_PAYLOAD_HEADER_FILTER\", consumerSoapHeaderFilter);";
  protected final String TEXT_10 = NL + "\t\t\t\t\tbind(\"DEFAULT_CXF_BINDING\", new CXFProviderBinding());";
  protected final String TEXT_11 = NL + "                org.apache.cxf.jaxrs.AbstractJAXRSFactoryBean factory_";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "                    org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf_";
  protected final String TEXT_14 = " = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();" + NL + "                    factory_";
  protected final String TEXT_15 = " = sf_";
  protected final String TEXT_16 = ";" + NL + "\t\t\t\t\tsf_";
  protected final String TEXT_17 = ".setServiceClass(";
  protected final String TEXT_18 = ".class);" + NL + "\t\t\t\t\tsf_";
  protected final String TEXT_19 = ".setResourceProvider(";
  protected final String TEXT_20 = ".class, new org.apache.camel.component.cxf.jaxrs.CamelResourceProvider(";
  protected final String TEXT_21 = ".class));" + NL + "\t\t\t\t\tsf_";
  protected final String TEXT_22 = ".setProvider(new CxfPayloadProvider());" + NL + "\t\t\t\t\t// avoid JAXBException in runtime" + NL + "\t\t\t\t\tsf_";
  protected final String TEXT_23 = ".setProvider(new org.apache.cxf.jaxrs.provider.SourceProvider());";
  protected final String TEXT_24 = NL + "                            org.apache.cxf.jaxrs.security.JAASAuthenticationFilter jaas_";
  protected final String TEXT_25 = " = new org.apache.cxf.jaxrs.security.JAASAuthenticationFilter();" + NL + "                            jaas_";
  protected final String TEXT_26 = ".setContextName(\"karaf\");" + NL + "                            sf_";
  protected final String TEXT_27 = ".setProvider(jaas_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "                            if (null != securityProps) {" + NL + "                                org.talend.esb.security.saml.SAMLRESTUtils.configureServer(sf_";
  protected final String TEXT_30 = ", securityProps);";
  protected final String TEXT_31 = NL + "                                sf_";
  protected final String TEXT_32 = ".getInInterceptors().add(authorizationInterceptor);";
  protected final String TEXT_33 = NL + "                            }";
  protected final String TEXT_34 = NL + "                    org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean cf_";
  protected final String TEXT_35 = " = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean() {" + NL + "                        // https://issues.apache.org/jira/browse/CAMEL-7229" + NL + "                        public void setBus(org.apache.cxf.Bus bus) {" + NL + "                            if (null == this.bus) {" + NL + "                                super.setBus(bus);" + NL + "                            }" + NL + "                        };" + NL + "                    };" + NL + "                    factory_";
  protected final String TEXT_36 = " = cf_";
  protected final String TEXT_37 = ";";
  protected final String TEXT_38 = NL + "                    cf_";
  protected final String TEXT_39 = ".setServiceClass(";
  protected final String TEXT_40 = ".class);";
  protected final String TEXT_41 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_42 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = "; ";
  protected final String TEXT_47 = NL + "                            cf_";
  protected final String TEXT_48 = ".setUsername(";
  protected final String TEXT_49 = ");" + NL + "                            cf_";
  protected final String TEXT_50 = ".setPassword(decryptedPassword_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "                            if (null != stsProperties) {" + NL + "                                java.util.Map<String, String> securityProps = new java.util.HashMap<String, String>(stsProperties);" + NL + "                                securityProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME, ";
  protected final String TEXT_53 = ");" + NL + "                                securityProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD, decryptedPassword_";
  protected final String TEXT_54 = ");" + NL + "                                org.apache.cxf.ws.security.trust.STSClient stsClient =" + NL + "                                    org.talend.esb.security.saml.STSClientUtils.createSTSClient(cf_";
  protected final String TEXT_55 = ".getBus(), securityProps);";
  protected final String TEXT_56 = NL + "                                    org.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, ";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "                                org.talend.esb.security.saml.SAMLRESTUtils.configureClient(cf_";
  protected final String TEXT_59 = ", stsClient);" + NL + "                            }";
  protected final String TEXT_60 = NL + "                factory_";
  protected final String TEXT_61 = ".setAddress(getCXFRSEndpointAddress(";
  protected final String TEXT_62 = "));";
  protected final String TEXT_63 = NL + "\t\t\t\tfactory_";
  protected final String TEXT_64 = ".setAddress(";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "                    factory_";
  protected final String TEXT_67 = ".setServiceName(new javax.xml.namespace.QName(";
  protected final String TEXT_68 = NL + "                        ";
  protected final String TEXT_69 = ",";
  protected final String TEXT_70 = NL + "                        ";
  protected final String TEXT_71 = "));" + NL + "                    if (null == bundleContext) {" + NL + "                        factory_";
  protected final String TEXT_72 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "                    }";
  protected final String TEXT_73 = NL + "                            factory_";
  protected final String TEXT_74 = ".setAddress(\"locator://rest\");";
  protected final String TEXT_75 = NL + "                        org.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_";
  protected final String TEXT_76 = " = new org.talend.esb.servicelocator.cxf.LocatorFeature();";
  protected final String TEXT_77 = NL + "                            java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_78 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_79 = NL + "                                slCustomProps_";
  protected final String TEXT_80 = ".put(";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "                                locatorFeature_";
  protected final String TEXT_84 = ".setAvailableEndpointProperties(slCustomProps_";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "                                locatorFeature_";
  protected final String TEXT_87 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "                        factory_";
  protected final String TEXT_90 = ".getFeatures().add(locatorFeature_";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "                    // {baseUri}cCXFRS" + NL + "                    factory_";
  protected final String TEXT_93 = ".setServiceName(new javax.xml.namespace.QName(";
  protected final String TEXT_94 = ", \"cCXFRS\"));";
  protected final String TEXT_95 = NL + "                    if (eventFeature != null) {" + NL + "                        factory_";
  protected final String TEXT_96 = ".getFeatures().add(eventFeature);" + NL + "                    } else {" + NL + "                        factory_";
  protected final String TEXT_97 = ".getFeatures().add(new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\").getBean(org.talend.esb.sam.agent.feature.EventFeature.class));" + NL + "                    }";
  protected final String TEXT_98 = NL + "                    final String correlationId_";
  protected final String TEXT_99 = " = ";
  protected final String TEXT_100 = ";" + NL + "                    if (null != correlationId_";
  protected final String TEXT_101 = " && correlationId_";
  protected final String TEXT_102 = ".length() > 0) {" + NL + "                        correlationIDCallbackHandler_";
  protected final String TEXT_103 = ".setCorrelationId(correlationId_";
  protected final String TEXT_104 = ");" + NL + "                        factory_";
  protected final String TEXT_105 = ".getProperties(true).put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, " + NL + "                            correlationIDCallbackHandler_";
  protected final String TEXT_106 = ");" + NL + "                    }" + NL + "                    factory_";
  protected final String TEXT_107 = ".getFeatures().add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_108 = NL + "                bind(\"";
  protected final String TEXT_109 = "\", factory_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\t\t\t\t\tbind(";
  protected final String TEXT_112 = ", new ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = "));";
  protected final String TEXT_115 = NL + "\t\t\t\t{" + NL + "\t\t\t\t\tObject beanInstance = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t\tif(beanInstance != null){" + NL + "\t\t\t\t\t\tbind(";
  protected final String TEXT_117 = ", beanInstance);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}";
  protected final String TEXT_118 = NL + "\t\t\t\tbind(";
  protected final String TEXT_119 = ", new ";
  protected final String TEXT_120 = "(";
  protected final String TEXT_121 = "));";
  protected final String TEXT_122 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t{";
  protected final String TEXT_123 = "\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_124 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_125 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = "; ";
  protected final String TEXT_130 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tjavax.jms.ConnectionFactory jmsConnectionFactory = new org.apache.activemq.ActiveMQConnectionFactory( ";
  protected final String TEXT_131 = ", decryptedPassword_";
  protected final String TEXT_132 = " ,";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\t\t\t\t\tjavax.jms.ConnectionFactory jmsConnectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL;
  protected final String TEXT_137 = NL + "\t\t\t\torg.apache.activemq.pool.PooledConnectionFactory pooledConnectionFactory_";
  protected final String TEXT_138 = " " + NL + "\t\t\t\t\t= new org.apache.activemq.pool.PooledConnectionFactory();" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_139 = ".setConnectionFactory(jmsConnectionFactory);" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_140 = ".setExpiryTimeout(";
  protected final String TEXT_141 = "L);" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_142 = ".setIdleTimeout(";
  protected final String TEXT_143 = ");" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_144 = ".setMaxConnections(";
  protected final String TEXT_145 = ");" + NL + "\t\t\t\tpooledConnectionFactory_";
  protected final String TEXT_146 = ".setMaximumActiveSessionPerConnection(";
  protected final String TEXT_147 = ");" + NL + "\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_148 = "," + NL + "\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_149 = "(pooledConnectionFactory_";
  protected final String TEXT_150 = "));\t";
  protected final String TEXT_151 = "\t\t\t\t" + NL + "\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_152 = "," + NL + "\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_153 = "(jmsConnectionFactory));";
  protected final String TEXT_154 = NL + "\t\t\t\t}";
  protected final String TEXT_155 = NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\tjavax.jms.ConnectionFactory jmsConnectionFactory = new com.ibm.mq.jms.MQQueueConnectionFactory();" + NL + "\t       \t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setHostName(";
  protected final String TEXT_156 = ");" + NL + "\t       \t\t\ttry {" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setPort(";
  protected final String TEXT_157 = ");" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setCCSID(866);" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setTransportType(";
  protected final String TEXT_158 = ");" + NL + "\t       \t\t\t\t((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setQueueManager(";
  protected final String TEXT_159 = ");\t" + NL + "\t       \t\t\t} catch (javax.jms.JMSException e) {" + NL + "\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_160 = NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_161 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_162 = "(jmsConnectionFactory));";
  protected final String TEXT_163 = NL + "\t\t\t\t\torg.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter";
  protected final String TEXT_164 = " " + NL + "\t\t\t\t\t\t\t= new org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter();" + NL + "       \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_165 = ".setUsername(";
  protected final String TEXT_166 = ");" + NL + "       \t\t\t\t";
  protected final String TEXT_167 = NL + "                    ";
  protected final String TEXT_168 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_169 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_170 = ");";
  protected final String TEXT_171 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_172 = " = ";
  protected final String TEXT_173 = "; ";
  protected final String TEXT_174 = NL + "                           \t\t\t\t" + NL + "      \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_175 = ".setPassword(decryptedPassword_";
  protected final String TEXT_176 = ");" + NL + "       \t\t\t\tconnectionFactoryAdapter";
  protected final String TEXT_177 = ".setTargetConnectionFactory(jmsConnectionFactory);" + NL + "       " + NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_178 = "," + NL + "\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_179 = "(connectionFactoryAdapter";
  protected final String TEXT_180 = "));";
  protected final String TEXT_181 = NL + "\t\t\t\t\t}";
  protected final String TEXT_182 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_183 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_184 = ");";
  protected final String TEXT_185 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_186 = " = ";
  protected final String TEXT_187 = "; ";
  protected final String TEXT_188 = "\t\t\t\t" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_189 = "," + NL + "\t\t\t\t\t\t\t\tnew org.apache.camel.component.amqp.AMQPComponent(org.apache.qpid.amqp_1_0.jms.impl.ConnectionFactoryImpl.createFromURL(";
  protected final String TEXT_190 = ")));" + NL + "\t\t\t\t\t\t//((org.apache.camel.component.amqp.AMQPComponent) camelContext.getComponent(";
  protected final String TEXT_191 = ")).getConfiguration().setClientId(\"";
  protected final String TEXT_192 = "\" + java.util.UUID.randomUUID().toString());" + NL + "\t\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_193 = "\t\t\t\t" + NL + "\t\t\t\t{\t" + NL + "\t\t\t\t\t org.apache.camel.component.mqtt.MQTTComponent mqttComponent = new org.apache.camel.component.mqtt.MQTTComponent(){" + NL + "\t\t\t\t\t\t @Override" + NL + "\t\t\t\t\t\t\tprotected org.apache.camel.Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {" + NL + "\t\t\t\t\t\t\t org.apache.camel.component.mqtt.MQTTEndpoint endpoint = " + NL + "\t\t\t\t\t\t\t\t\t (org.apache.camel.component.mqtt.MQTTEndpoint) super.createEndpoint(uri, remaining, parameters);" + NL + "\t\t\t\t\t\t\t org.apache.camel.component.mqtt.MQTTConfiguration config = endpoint.getConfiguration();" + NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t ";
  protected final String TEXT_194 = "              ";
  protected final String TEXT_195 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_196 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_199 = " = ";
  protected final String TEXT_200 = "; ";
  protected final String TEXT_201 = NL + "                    config.setUserName(";
  protected final String TEXT_202 = ");" + NL + "                    config.setPassword(decryptedPassword_";
  protected final String TEXT_203 = ");";
  protected final String TEXT_204 = "\t\t " + NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t config.setHost(";
  protected final String TEXT_205 = ");" + NL + "\t\t\t\t\t\t\t config.setConnectAttemptsMax(";
  protected final String TEXT_206 = ");" + NL + "\t\t\t\t\t\t\t config.setReconnectAttemptsMax(";
  protected final String TEXT_207 = ");" + NL + "\t\t\t\t\t\t\t config.setReconnectDelay(";
  protected final String TEXT_208 = ");" + NL + "\t\t\t\t\t\t\t config.setQualityOfService(\"";
  protected final String TEXT_209 = "\");" + NL + "\t\t\t\t\t\t\t config.setConnectWaitInSeconds(";
  protected final String TEXT_210 = ");" + NL + "\t\t\t\t\t\t\t config.setDisconnectWaitInSeconds(";
  protected final String TEXT_211 = ");" + NL + "\t\t\t\t\t\t\t config.setSendWaitInSeconds(";
  protected final String TEXT_212 = ");" + NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t ";
  protected final String TEXT_213 = NL + "\t\t\t\t\t\t\t \tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "\t\t\t\t\t\t\t\t.getInstance(javax.net.ssl.TrustManagerFactory" + NL + "\t\t\t\t\t\t\t\t\t\t.getDefaultAlgorithm());" + NL + "\t" + NL + "\t\t\t\t\t\t\t\tjava.io.FileInputStream fis = new java.io.FileInputStream(" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_214 = ");" + NL + "\t\t\t\t\t\t\t\tjava.security.KeyStore ks = java.security.KeyStore" + NL + "\t\t\t\t\t\t\t\t\t\t.getInstance(java.security.KeyStore.getDefaultType());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = NL + "                    \t\t\t";
  protected final String TEXT_216 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_217 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_220 = " = ";
  protected final String TEXT_221 = "; ";
  protected final String TEXT_222 = NL + "                       " + NL + "\t\t\t\t\t\t\t\tks.load(fis, decryptedPassword_";
  protected final String TEXT_223 = ".toCharArray());" + NL + "\t\t\t\t\t\t\t\tfis.close();" + NL + "\t\t\t\t\t\t\t\ttmf.init(ks);" + NL + "\t\t\t\t\t\t\t\tjavax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\t\t\t\t\t\t\tsslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());" + NL + "\t\t\t\t\t\t\t\tconfig.setSslContext(sslContext);" + NL + "\t\t\t\t\t\t\t ";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t " + NL + "\t\t\t\t\t\t\t return endpoint;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t };" + NL + "\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_225 = ",mqttComponent);" + NL + "\t\t\t\t}";
  protected final String TEXT_226 = NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t  javax.jms.ConnectionFactory jmsConnectionFactory;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\t\t\tcamelContext.addComponent(";
  protected final String TEXT_228 = "," + NL + "\t\t\t\t\t\t\torg.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_229 = "(jmsConnectionFactory));" + NL + "\t\t\t\t\t}";
  protected final String TEXT_230 = NL + "            return java.util.Collections.singletonMap(camelContext.getName(), (CamelContext) camelContext);" + NL + "\t\t}";
  protected final String TEXT_231 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	 Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess)v.get(0);
	
	String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;
	
	boolean stats = codeGenArgument.isStatistics();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(process.getName().toLowerCase());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(process.getName().toLowerCase());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_5);
    
			//process cConfig components first 
			List<? extends INode> camelContextNodes = process.getNodesOfType("cConfig");
			for(INode node: camelContextNodes){
                boolean useMdcLogging = Boolean.parseBoolean(ElementParameterParser.getValue(node, "__USE_MDC_LOGGING__"));
                if(useMdcLogging){

    stringBuffer.append(TEXT_6);
    
                }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__"));
    
			} 

    stringBuffer.append(TEXT_8);
    
			boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();
			List<? extends INode> cxfNodes = process.getNodesOfType("cCXF");
			if( null != cxfNodes && cxfNodes.size() >0 ){
				boolean hasCXFConsumer = false;
				boolean hasCXFSAMLProvider = false;
				for(INode n: cxfNodes){
					int incomingConnections = n.getIncomingConnections().size();
					if(incomingConnections > 0){
						hasCXFConsumer = true;
					}else{
						String dataformat = ElementParameterParser.getValue(n, "__DATAFORMAT__");
						
						String useServiceRegistry = ElementParameterParser.getValue(n, "__ENABLE_REGISTRY__");
						if(!isStudioEEVersion || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
							useServiceRegistry = "false";
						}
						
						String useSecurity = ElementParameterParser.getValue(n, "__ENABLE_SECURITY__");
						if("true".equals(useServiceRegistry) || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
							useSecurity = "false";
						}
						
						if("true".equals(useServiceRegistry) || ("true".equals(useSecurity) && "SAML".equals(ElementParameterParser.getValue(n, "__SECURITY_TYPE__")))){
							hasCXFSAMLProvider = true;
						}
						if(hasCXFConsumer && hasCXFSAMLProvider){
							break;
						}
					}
				}
				if(hasCXFConsumer){

    stringBuffer.append(TEXT_9);
    
				}
				if(hasCXFSAMLProvider){

    stringBuffer.append(TEXT_10);
    				}
			}

			for (INode node : process.getNodesOfType("cCXFRS")) {
                String cid = node.getUniqueName();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
                boolean isProvider = node.getIncomingConnections().isEmpty();
                if (isProvider) {
                    String serviceClass = ("MANUAL".equals(ElementParameterParser.getValue(node, "__SERVICE_TYPE__")))
                        ? ("Service_" + cid) : ElementParameterParser.getValue(node, "__RESOURCE_CLASS__");

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(serviceClass);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(serviceClass);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(serviceClass);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
                    if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"))) {
                        if("BASIC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
                        } else if ("SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     if ("true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"))) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
     } 
    stringBuffer.append(TEXT_33);
    
                        }
                    }
				} else {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
                    if ("RESOURCECLASS".equals(ElementParameterParser.getValue(node, "__SERVICE_TYPE__"))) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(node, "__RESOURCE_CLASS__"));
    stringBuffer.append(TEXT_40);
    
                    }
                    if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"))) {
                    	String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    }
    
                        if ("BASIC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USERNAME__"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
                        } else if ("SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USERNAME__"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
     if ("true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"))) { 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROLE_NAME__"));
    stringBuffer.append(TEXT_57);
     } 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
                        }
                    }
				}

     
				if (isProvider) {

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_62);
     				} else {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_65);
     
				}

    
                if ("true".equals(ElementParameterParser.getValue(node, "__SERVICE_LOCATOR__"))) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SERVICE_NAMESPACE__"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SERVICE_NAME__"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
                        if (!isProvider) {

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
                        }

    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
                        List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");
                        if (!customProperties.isEmpty()) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
                            for (Map<String, String> custProp : customProperties) {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_82);
    
                            }

                            if (isProvider) {

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
                            } else {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
                            }
                        }

    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
                } else if (!isProvider) {

    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_94);
    
                }

                if ("true".equals(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
                }

                if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__"))) {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
                }

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    
			}

			//then process cBeanRegister components
			List<? extends INode> beanRegisterNodes = process.getNodesOfType("cBeanRegister");
			if(beanRegisterNodes != null && beanRegisterNodes.size()>0){
			for(INode node: beanRegisterNodes){
				String id = ElementParameterParser.getValue(node, "__ID__");
				String isSimple = ElementParameterParser.getValue(node, "__SIMPLE_CONFIG__");
				String classQualifiedName = ElementParameterParser.getValue(node, "__CLASS_QUALIFIED_NAME__");
				String hasArguments = ElementParameterParser.getValue(node, "__SPECIFY_ARGUMENTS__");
				List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
				
				String code = ElementParameterParser.getValue(node, "__CODE__");
				
				if("true".equals(isSimple)){
					StringBuilder sb = new StringBuilder();
					if("true".equals(hasArguments)){
						for(Map<String, String> s: arguments){
							if(sb.length() == 0){
								sb.append(s.get("VALUE"));
							}else{
								sb.append(",");
								sb.append(s.get("VALUE"));
							}
						}
					}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(classQualifiedName);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_114);
    
				}else{

    stringBuffer.append(TEXT_115);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_117);
    
				}
			}
			}
			
			//after, process cDataset 
			List<? extends INode> datasetNodes = process.getNodesOfType("cDataset");
			for(INode n: datasetNodes){
				String beanID = ElementParameterParser.getValue(n, "__DATASET_NAME__");
				String registerNewBean = ElementParameterParser.getValue(n, "__REGISTER_DATASET_BEAN__");
				if(!"true".equals(registerNewBean)){
					continue;
				}
				String beanClass = ElementParameterParser.getValue(n, "__BEAN_CLASS__");
				List<Map<String, String>> beanArguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(n, "__BEAN_ARGUMENTS__");
				StringBuilder sb = new StringBuilder();
				if(beanArguments != null){
					for(Map<String,String> map: beanArguments){
						if(sb.length() == 0){
							sb.append(map.get("VALUE"));
						}else{
							sb.append(",");
							sb.append(map.get("VALUE"));
						}
					}
				}

    stringBuffer.append(TEXT_118);
    stringBuffer.append(beanID);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(beanClass);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_121);
    
			}
            //cMQConnectionFactory http://jira.talendforge.org/browse/TESB-4860
			List<? extends INode> jmsCFNodes = process.getNodesOfType("cMQConnectionFactory");
			for(INode node: jmsCFNodes){
				NodeParamsHelper helper = new NodeParamsHelper(node);
				//Use transaction http://jira.talendforge.org/browse/TESB-5160 By LiXiaopeng
				String useTransaction = ElementParameterParser.getValue(node, "__USE_TRANSACTION__");
				String transactedMethodStr = "";
				if("true".equals(useTransaction)){
					transactedMethodStr = "Transacted";
				}
			
				//Component Name
				String name = node.getUniqueName().replace("_", "");
				name = "\"" + name + "\"";
				    // ElementParameterParser.getValue(node, "__NAME__").trim();
    				//Remove unnecessary subfix
    				//name += "+";
    				//name += ElementParameterParser.getValue(node, "__SUBFIX__").trim();
			
				//ActiveMQ
				String mqType = ElementParameterParser.getValue(node, "__MQ_TYPE__");
				if("ActiveMQ".equals(mqType)){
					String amqUri = ElementParameterParser.getValue(node, "__AMQ_BROKER_URI__").trim();
					

    stringBuffer.append(TEXT_122);
    
				String useActiveMQAuth = ElementParameterParser.getValue(node, "__AMQ_AUTH__");
				if ("true".equals(useActiveMQAuth)){
					String username = ElementParameterParser.getValue(node, "__AMQ_USERNAME__");
					String cid = node.getUniqueName();
					String passwordFieldName = "__AMQ_PASSWORD__";

    stringBuffer.append(TEXT_123);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_126);
    } else {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_133);
    				
				}else{

    stringBuffer.append(TEXT_134);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_135);
    						
				}

    stringBuffer.append(TEXT_136);
    
				String amqPool = ElementParameterParser.getValue(node, "__AMQ_POOL__").trim();
				if("true".equals(amqPool)){
				     String amq_pool_max_connections = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_CONNECTIONS__").trim();
				     String amq_pool_max_active = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_ACTIVE__").trim();
				     String amq_pool_idle_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_IDLE_TIMEOUT__").trim();
				     String amq_pool_expiry_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_EXPIRY_TIMEOUT__").trim();
				     
				     if(amq_pool_max_connections.startsWith("\"")){
						 amq_pool_max_connections = amq_pool_max_connections.substring(1);
					 }
					 if(amq_pool_max_connections.endsWith("\"")){
						 amq_pool_max_connections = amq_pool_max_connections.substring(0, amq_pool_max_connections.length() - 1);
					 }
				     if(amq_pool_max_active.startsWith("\"")){
						 amq_pool_max_active = amq_pool_max_active.substring(1);
					 }
					 if(amq_pool_max_active.endsWith("\"")){
						 amq_pool_max_active = amq_pool_max_active.substring(0, amq_pool_max_active.length() - 1);
					 }
				     if(amq_pool_idle_timeout.startsWith("\"")){
						 amq_pool_idle_timeout = amq_pool_idle_timeout.substring(1);
					 }
					 if(amq_pool_idle_timeout.endsWith("\"")){
						 amq_pool_idle_timeout = amq_pool_idle_timeout.substring(0, amq_pool_idle_timeout.length() - 1);
					 }
				     if(amq_pool_expiry_timeout.startsWith("\"")){
						 amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(1);
					 }
					 if(amq_pool_expiry_timeout.endsWith("\"")){
						 amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(0, amq_pool_expiry_timeout.length() - 1);
					 }

    stringBuffer.append(TEXT_137);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(amq_pool_expiry_timeout);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(amq_pool_idle_timeout);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(amq_pool_max_connections);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(amq_pool_max_active);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_150);
    
					 
				}else{

    stringBuffer.append(TEXT_151);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_153);
    				
				    }

    stringBuffer.append(TEXT_154);
    
				}else if("WebSphere MQ".equals(mqType)){
					String wmqServer = ElementParameterParser.getValue(node, "__WQM_SEVER__");
					String wmqPort = ElementParameterParser.getValue(node, "__WMQ_PORT__");
					String wmqTransportType = ElementParameterParser.getValue(node, "__WMQ_TRANSPORT_TYPE__");
					String wmqUM = ElementParameterParser.getValue(node, "__WMQ_QUEUE_MANAGER__");
					
					//Username and password, http://jira.talendforge.org/browse/TESB-4073
					String username = ElementParameterParser.getValue(node, "__WMQ_USERNAME__");
					String useAuth = ElementParameterParser.getValue(node, "__WMQ_AUTH__");
					
					if(wmqPort.startsWith("\"")){
						wmqPort = wmqPort.substring(1);
					}
					if(wmqPort.endsWith("\"")){
						wmqPort = wmqPort.substring(0, wmqPort.length() - 1);
					}
					if(wmqTransportType.startsWith("\"")){
						wmqTransportType = wmqTransportType.substring(1);
					}
					if(wmqTransportType.endsWith("\"")){
						wmqTransportType = wmqTransportType.substring(0, wmqTransportType.length() - 1);
					}
					

    stringBuffer.append(TEXT_155);
    stringBuffer.append(wmqServer);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(wmqPort);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(wmqTransportType);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(wmqUM);
    stringBuffer.append(TEXT_159);
    
					if("false".equals(useAuth)){

    stringBuffer.append(TEXT_160);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_162);
    					
					}else{

    stringBuffer.append(TEXT_163);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_166);
    
                    String cid = node.getUniqueName();
                    String passwordFieldName = "__WMQ_PASSWORD__";
                    
    stringBuffer.append(TEXT_167);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_170);
    } else {
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_173);
    }
    stringBuffer.append(TEXT_174);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_177);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_180);
    						
					}					

    stringBuffer.append(TEXT_181);
    
				}else if("AMQP".equals(mqType)){
					String cid = node.getUniqueName();
					String host = helper.getStringParam("__AMQP_BROKER_URI__");
					boolean useSSL = helper.getBoolParam("__AMQP_SSL__");
					boolean useAuth = helper.getBoolParam("__AMQP_USE_AUTH__");
					
					StringBuilder ep = new StringBuilder();
					ep.append("\"");
					ep.append(useSSL?"amqps":"amqp");
					ep.append("://\" + ");
					if(useAuth) {
						ep.append(helper.getStringParam("__AMQP_USERNAME__"));
						ep.append("+ \":\" +");
	                	String passwordFieldName = "__AMQP_PASSWORD__";

	                    
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_184);
    } else {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_187);
    }
    
	                    
						ep.append("decryptedPassword_");
	                    ep.append(cid);
						ep.append("+ \"@\" +");
					}
					ep.append(host);
					String port = helper.getStringParam("__AMQP_PORT__");
					if (!port.isEmpty()) {
						ep.append("+ \":\" + ");
						ep.append(port);
					}

    stringBuffer.append(TEXT_188);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(ep.toString());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(process.getName().toLowerCase());
    stringBuffer.append(TEXT_192);
    
				}else if("MQTT".equals(mqType)){
					String cid = node.getUniqueName();
					String host = helper.getStringParam("__MQTT_HOST__");
					String port = helper.getStringParam("__MQTT_PORT__");
					boolean useSSL = helper.getBoolParam("__MQTT_SSL__");
					String brokerUri = "\""+(useSSL?"ssl":"tcp") + "://\"+" + host + "+\":\"+" + port;

    stringBuffer.append(TEXT_193);
    
                String useActiveMQTTAuth = ElementParameterParser.getValue(node, "__MQTT_AUTH__");
                if ("true".equals(useActiveMQTTAuth)){
                    String username = ElementParameterParser.getValue(node, "__MQTT_USERNAME__");
                    String passwordFieldName = "__MQTT_PASSWORD__";

    stringBuffer.append(TEXT_194);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_197);
    } else {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
                  
                }

    stringBuffer.append(TEXT_204);
    stringBuffer.append(brokerUri);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(helper.getStringParam("__MQTT_CONNECT_ATTEMPTS__"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(helper.getStringParam("__MQTT_RECONNECT_ATTEMPTS__"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(helper.getStringParam("__MQTT_RECONNECT_DELAY__"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(helper.getStringParam("__MQTT_QOS__"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(helper.getStringParam("__MQTT_CONNECT_WAIT_IN_SECONDS__"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(helper.getStringParam("__MQTT_DISCONNECT_WAIT_IN_SECONDS__"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(helper.getStringParam("__MQTT_SEND_WAIT_IN_SECONDS__"));
    stringBuffer.append(TEXT_212);
    if("true".equals(helper.getStringParam("__MQTT_SSL__"))){
    stringBuffer.append(TEXT_213);
    stringBuffer.append(helper.getStringParam("__MQTT_SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_214);
    String passwordFieldName = "__MQTT_SSL_TRUST_STORE_PASSWORD__";
    stringBuffer.append(TEXT_215);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_218);
    } else {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    }
    stringBuffer.append(TEXT_224);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_225);
    
				}else if("Other".equals(mqType)){

    stringBuffer.append(TEXT_226);
    stringBuffer.append(ElementParameterParser.getValue(node, "__OTHER_CODE__"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_229);
    
				}
			
			}
			//http://jira.talendforge.org/browse/TESB-4087: Change CamelContext name

    stringBuffer.append(TEXT_230);
    stringBuffer.append(TEXT_231);
    return stringBuffer.toString();
  }
}
