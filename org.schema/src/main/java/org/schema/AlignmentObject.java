package org.schema;

public class AlignmentObject extends Thing
{
	protected AlignmentObject()
	{
		context = "http://schema.org/";
		type = "http://schema.org/AlignmentObject";
	}
	public String alignmentType;
	public String educationalFramework;
	public String targetDescription;
	public String targetName;
	public String targetUrl;
}
