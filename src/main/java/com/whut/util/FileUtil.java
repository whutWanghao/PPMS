package com.whut.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by WH on 2017/6/27.
 * DOM方式生成XML
 */
public class FileUtil {
    public void createXMLByDOM(File dest){
        //创建DocumentBuilderFactory
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try

        {
            //创建DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            //创建Document
            Document document = builder.newDocument();
            //设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
            document.setXmlStandalone(true);
            //创建根节点
            Element pipenodes = document.createElement("pipenodes");
            //创建子节点并设置属性
            Element node = document.createElement("node");
            node.setAttribute("number", "001");

            //为node添加子节点
            Element longitude = document.createElement("longitude");
            longitude.setTextContent("114.305902");
            node.appendChild(longitude);

            Element latitude = document.createElement("latitude");
            latitude.setTextContent("30.517137");
            node.appendChild(latitude);
            //为根结点添加子节点
            pipenodes.appendChild(node);

            //实现生成XML文件，创建TransformerFactory对象
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            //创建Transformer对象
            Transformer transformer=transformerFactory.newTransformer();
            //输出数据时换行
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            //将DOM树转换成XML
            transformer.transform(new DOMSource(document),new StreamResult(dest));
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
