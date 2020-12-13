package com.company;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

public class PersonsVector {
    private static Vector<Person> personsVector;

    PersonsVector() { personsVector = Builder.setPersonsVector(); }

    public Vector<Person> getPersonsVector() { return personsVector; }

    static class Builder {
        public static Vector<Person> setPersonsVector() {
            Vector<Person> personsVector = new Vector<>();
            Person person = null;
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            try {
                XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("C:\\СИТАРИС\\laba4-5\\src\\com\\company\\xml.xml"));
                while (reader.hasNext()) {
                    XMLEvent xmlEvent = reader.nextEvent();
                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();
                        if (startElement.getName().getLocalPart().equals("person")) {
                            person = new Person();
                        } else if (startElement.getName().getLocalPart().equals("id")) {
                            xmlEvent = reader.nextEvent();
                            person.setId(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        } else if (startElement.getName().getLocalPart().equals("name")) {
                            xmlEvent = reader.nextEvent();
                            person.setName(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("surname")) {
                            xmlEvent = reader.nextEvent();
                            person.setSurname(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("height")) {
                            xmlEvent = reader.nextEvent();
                            person.setHeight((Integer.parseInt(xmlEvent.asCharacters().getData())));
                        } else if (startElement.getName().getLocalPart().equals("weight")) {
                            xmlEvent = reader.nextEvent();
                            person.setWeight(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                    }
                    if (xmlEvent.isEndElement()) {
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals("person")) personsVector.add(person);
                    }
                }
            }
            catch (FileNotFoundException | XMLStreamException exc) { exc.printStackTrace(); }
            return personsVector;
        }
    }
}
