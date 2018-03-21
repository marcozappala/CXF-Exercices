package model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import adapters.StudentAdapter;

@XmlJavaTypeAdapter(StudentAdapter.class)
public interface Student {
  String getName();
}
