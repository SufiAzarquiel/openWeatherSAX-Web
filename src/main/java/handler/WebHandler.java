package handler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import model.Intervalo;

public class WebHandler extends DefaultHandler {

	private XMLReader xr;
	private InputSource is;
	private ArrayList<Intervalo> intervalos;
	private Intervalo intervalo;

	public WebHandler(String strUrl) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		parserFactory.setNamespaceAware(true);
		SAXParser parser;
		try {
			parser = parserFactory.newSAXParser();
			xr = parser.getXMLReader();
			this.is = new InputSource(new URL(strUrl).openStream());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		xr.setContentHandler(this);
		xr.setErrorHandler(this);
	}

	public ArrayList<Intervalo> parsear() {
		// En este caso como el xml esta en Internet debemos crear el stream y
		// con este el source
		try {
			// La llamada a este metodo es el que desencadena todo el proceso
			xr.parse(this.is);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return intervalos;
	}

	@Override
	public void startDocument() throws SAXException {
		intervalos = new ArrayList<Intervalo>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		if (localName == "time") {
			intervalo = new Intervalo();
			intervalo.setHoraFinal(attributes.getValue("to"));
			intervalo.setHoraInicio(attributes.getValue("from"));
		} else if (localName == "symbol") {
			intervalo.setSimbolo(attributes.getValue("var"));
			intervalo.setCielo(attributes.getValue("name"));
		} else if (localName == "precipitation") {
			intervalo.setPrecipitacion(Integer.parseInt(attributes.getValue("probability")));
		} else if (localName == "temperature") {
			intervalo.setTemperaturaMaxima(Float.parseFloat(attributes.getValue("max")) - 273.15f);
			intervalo.setTemperaturaMinima(Float.parseFloat(attributes.getValue("min")) - 273.15f);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);

		if (localName == "time") {
			intervalos.add(intervalo);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String.valueOf(ch, start, length);
	}

}
