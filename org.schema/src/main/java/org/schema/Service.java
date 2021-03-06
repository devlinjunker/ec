package org.schema;

/**
 * Schema.org/Service
 * A service provided by an organization, e.g. delivery service, print services, etc.
 *
 * @author schema.org
 * @class Service
 * @module org.schema
 * @extends Intangible
 */
public class Service extends Intangible {
	/**
	 * Schema.org/audience
	 * An intended audience, i.e. a group for whom something was created.
	 *
	 * @property audience
	 * @type Audience
	 */
	public Audience audience;
	/**
	 * Schema.org/award
	 * An award won by or for this item.
	 *
	 * @property award
	 * @type Text
	 */
	public String award;
	/**
	 * Schema.org/broker
	 * An entity that arranges for an exchange between a buyer and a seller.  In most cases a broker never acquires or releases ownership of a product or service involved in an exchange.  If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred.
	 *
	 * @property broker
	 * @type schema, Organization | schema,Person
	 */
	public Object broker;
	/**
	 * Schema.org/isRelatedTo
	 * A pointer to another, somehow related product (or multiple products).
	 *
	 * @property isRelatedTo
	 * @type schema, Service | schema,Product
	 */
	public Object isRelatedTo;
	/**
	 * Schema.org/providerMobility
	 * Indicates the mobility of a provided service (e.g. 'static', 'dynamic').
	 *
	 * @property providerMobility
	 * @type Text
	 */
	public String providerMobility;
	/**
	 * Schema.org/offers
	 * An offer to provide this item&#x2014;for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event.
	 *
	 * @property offers
	 * @type Offer
	 */
	public Offer offers;
	/**
	 * Schema.org/review
	 * A review of the item.
	 *
	 * @property review
	 * @type Review
	 */
	public Review review;
	/**
	 * Schema.org/brand
	 * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
	 *
	 * @property brand
	 * @type schema, Organization | schema,Brand
	 */
	public Object brand;
	/**
	 * Schema.org/areaServed
	 * The geographic area where a service or offered item is provided.
	 *
	 * @property areaServed
	 * @type schema, GeoShape | schema,Text | schema,Place | schema,AdministrativeArea
	 */
	public Object areaServed;
	/**
	 * Schema.org/hoursAvailable
	 * The hours during which this service or contact is available.
	 *
	 * @property hoursAvailable
	 * @type OpeningHoursSpecification
	 */
	public OpeningHoursSpecification hoursAvailable;
	/**
	 * Schema.org/produces
	 * The tangible thing generated by the service, e.g. a passport, permit, etc.
	 *
	 * @property produces
	 * @type Thing
	 */
	public Thing produces;
	/**
	 * Schema.org/availableChannel
	 * A means of accessing the service (e.g. a phone bank, a web site, a location, etc.).
	 *
	 * @property availableChannel
	 * @type ServiceChannel
	 */
	public ServiceChannel availableChannel;
	/**
	 * Schema.org/isSimilarTo
	 * A pointer to another, functionally similar product (or multiple products).
	 *
	 * @property isSimilarTo
	 * @type schema, Service | schema,Product
	 */
	public Object isSimilarTo;
	/**
	 * Schema.org/provider
	 * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller.
	 *
	 * @property provider
	 * @type schema, Organization | schema,Person
	 */
	public Object provider;
	/**
	 * Schema.org/serviceArea
	 * The geographic area where the service is provided.
	 *
	 * @property serviceArea
	 * @type schema, GeoShape | schema,Place | schema,AdministrativeArea
	 */
	public Object serviceArea;
	/**
	 * Schema.org/aggregateRating
	 * The overall rating, based on a collection of reviews or ratings, of the item.
	 *
	 * @property aggregateRating
	 * @type AggregateRating
	 */
	public AggregateRating aggregateRating;
	/**
	 * Schema.org/serviceOutput
	 * The tangible thing generated by the service, e.g. a passport, permit, etc.
	 *
	 * @property serviceOutput
	 * @type Thing
	 */
	public Thing serviceOutput;
	/**
	 * Schema.org/logo
	 * An associated logo.
	 *
	 * @property logo
	 * @type schema, URL | schema,ImageObject
	 */
	public Object logo;
	/**
	 * Schema.org/hasOfferCatalog
	 * Indicates an OfferCatalog listing for this Organization, Person, or Service.
	 *
	 * @property hasOfferCatalog
	 * @type OfferCatalog
	 */
	public OfferCatalog hasOfferCatalog;
	/**
	 * Schema.org/serviceAudience
	 * The audience eligible for this service.
	 *
	 * @property serviceAudience
	 * @type Audience
	 */
	public Audience serviceAudience;
	/**
	 * Schema.org/serviceType
	 * The type of service being offered, e.g. veterans' benefits, emergency relief, etc.
	 *
	 * @property serviceType
	 * @type Text
	 */
	public String serviceType;
	/**
	 * Schema.org/category
	 * A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
	 *
	 * @property category
	 * @type schema, Text | schema,Thing
	 */
	public Object category;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public Service() {
		context = "http://schema.org/";
		type = "Service";
	}

}