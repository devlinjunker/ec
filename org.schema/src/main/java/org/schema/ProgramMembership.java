package org.schema;

/**
 * Schema.org/ProgramMembership
 * Used to describe membership in a loyalty programs (e.g. "StarAliance"), traveler clubs (e.g. "AAA"), purchase clubs ("Safeway Club"), etc.
 *
 * @author schema.org
 * @class ProgramMembership
 * @module org.schema
 * @extends Intangible
 */
public class ProgramMembership extends Intangible {
	/**
	 * Schema.org/member
	 * A member of an Organization or a ProgramMembership. Organizations can be members of organizations; ProgramMembership is typically for individuals.
	 *
	 * @property member
	 * @type schema, Organization | schema,Person
	 */
	public Object member;
	/**
	 * Schema.org/programName
	 * The program providing the membership.
	 *
	 * @property programName
	 * @type Text
	 */
	public String programName;
	/**
	 * Schema.org/members
	 * A member of this organization.
	 *
	 * @property members
	 * @type schema, Organization | schema,Person
	 */
	public Object members;
	/**
	 * Schema.org/hostingOrganization
	 * The organization (airline, travelers' club, etc.) the membership is made with.
	 *
	 * @property hostingOrganization
	 * @type Organization
	 */
	public Organization hostingOrganization;
	/**
	 * Schema.org/membershipNumber
	 * A unique identifier for the membership.
	 *
	 * @property membershipNumber
	 * @type Text
	 */
	public String membershipNumber;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ProgramMembership() {
		context = "http://schema.org/";
		type = "ProgramMembership";
	}

}