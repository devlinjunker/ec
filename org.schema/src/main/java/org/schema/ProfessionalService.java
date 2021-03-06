package org.schema;

/**
 * Schema.org/ProfessionalService
 * Original definition: "provider of professional services."\n\nThe general [[ProfessionalService]] type for local businesses was deprecated due to confusion with [[Service]]. For reference, the types that it included were: [[Dentist]],
 * [[AccountingService]], [[Attorney]], [[Notary]], as well as types for several kinds of [[HomeAndConstructionBusiness]]: [[Electrician]], [[GeneralContractor]],
 * [[HousePainter]], [[Locksmith]], [[Plumber]], [[RoofingContractor]]. [[LegalService]] was introduced as a more inclusive supertype of [[Attorney]].
 *
 * @author schema.org
 * @class ProfessionalService
 * @module org.schema
 * @extends LocalBusiness
 */
public class ProfessionalService extends LocalBusiness {
	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public ProfessionalService() {
		context = "http://schema.org/";
		type = "ProfessionalService";
	}

}