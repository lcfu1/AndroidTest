package com.example.androidtest;

import com.example.androidtest.Util.LogUtil;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXContentHandler extends DefaultHandler{
    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        id=new StringBuilder();
        name=new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        nodeName=localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if("id".equals(nodeName)){
            id.append(ch, start, length);
        }else if("name".equals(nodeName)){
            name.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("app".equals(localName)){
            LogUtil.d("XMLActivity----------id=", id.toString().trim());
            LogUtil.d("XMLActivity----------name=", name.toString().trim());
            id.setLength(0);
            name.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
