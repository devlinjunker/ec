package org.schema;

/**
 * Schema.org/AggregateOffer
 * When a single product is associated with multiple offers (for example, the same pair of shoes is offered by different merchants), then AggregateOffer can be used.
 *
 * @author schema.org
 * @class AggregateOffer
 * @module org.schema
 * @extends Offer
 */
public class AggregateOffer extends Offer {
	/**
	 * Schema.org/offers
	 * An offer to provide this item&#x2014;for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event.
	 *
	 * @property offers
	 * @type Offer
	 */
	public Offer offers;
	/**
	 * Schema.org/highPrice
	 * The highest price of all offers available.
	 *
	 * @property highPrice
	 * @type schema, Number | schema,Text
	 */
	public Object highPrice;
	/**
	 * Schema.org/lowPrice
	 * The lowest price of all offers available.
	 *
	 * @property lowPrice
	 * @type schema, Number | schema,Text
	 */
	public Object lowPrice;
	/**
	 * Schema.org/offerCount
	 * The number of offers for the product.
	 *
	 * @property offerCount
	 * @type Integer
	 */
	public Integer offerCount;

	/**
	 * Constructor, automatically sets @context and @type.
	 *
	 * @constructor
	 */
	public AggregateOffer() {
		context = "http://schema.org/";
		type = "AggregateOffer";
	}

}