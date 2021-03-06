package cass.rollup;

import com.eduworks.ec.crypto.EcPk;
import org.cass.competency.EcCompetency;
import org.cass.competency.EcFramework;
import org.cass.competency.EcLevel;
import org.cass.profile.EcAssertion;
import org.stjs.javascript.Array;
import org.stjs.javascript.Date;
import org.stjs.javascript.functions.Callback1;
import org.stjs.javascript.functions.Function1;

/**
 * Data structure used to hold data relevant to a request to determine the competence of an individual.
 * (hereafter, "Inquiry")
 *
 * @author fritz.ray@eduworks.com
 * @author tom.buskirk@eduworks.com
 * @class InquiryPacket
 * @module org.cassproject
 */
public class InquiryPacket {

	public boolean root = false;
	/**
	 * One or more identifiers that identify an individual.
	 *
	 * @property subject
	 * @type EcPk[]
	 */
	public Array<EcPk> subject;
	/**
	 * Competency that this packet is inquiring about.
	 * May be multiple competencies that are either collapsed due to an inference loop, or are equivalent to one another.
	 *
	 * @property competency
	 * @type EcCompetency[]
	 */
	public Array<EcCompetency> competency;
	/**
	 * Framework that this inquiry is scoped to.
	 *
	 * @property context
	 * @type EcFramework
	 */
	public EcFramework context;
	/**
	 * Callback when this and all child inquiries have successfully reached a conclusion.
	 *
	 * @property success
	 * @type function(InquiryPacket)
	 */
	public Callback1<InquiryPacket> success;
	/**
	 * Callback if this inquiry requires additional information to proceed.
	 *
	 * @property ask
	 * @type string function(string)
	 */
	public Function1<String, String> ask;
	/**
	 * Callback if this inquiry fails.
	 *
	 * @property failure
	 * @type function(string)
	 */
	public Callback1<String> failure;
	/**
	 * Level that the competency is being measured at.
	 * May have multiple levels referring to multiple competencies due to cycles or equivalence.
	 *
	 * @property level
	 * @type EcLevel[]
	 */
	public Array<EcLevel> level;
	/**
	 * Packets that are equivalent to this packet. May be used when equivalence is best represented with additional packets.
	 *
	 * @property equivalentPackets
	 * @type InquiryPacket[]
	 */
	public Array<InquiryPacket> equivalentPackets;
	/**
	 * Packets that assist in determining the state of this packet.
	 *
	 * @property subPackets
	 * @type InquiryPacket[]
	 */
	public Array<InquiryPacket> subPackets;
	/**
	 * Datetime representing when this packet was created.
	 *
	 * @property dateCreated
	 * @internal
	 * @type number
	 */
	public double dateCreated;
	/**
	 * Mark true when assertions have been retrieved for this packet.
	 *
	 * @property hasCheckedAssertionsForCompetency
	 * @type boolean
	 */
	public boolean hasCheckedAssertionsForCompetency = false;
	/**
	 * Mark true when rollup rules have been processed for this packet.
	 *
	 * @property hasCheckedRollupRulesForCompetency
	 * @type boolean
	 */
	public boolean hasCheckedRollupRulesForCompetency = false;
	/**
	 * Mark true when relations have been processed for this packet.
	 *
	 * @property hasCheckedRelationshipsForCompetency
	 * @type boolean
	 */
	public boolean hasCheckedRelationshipsForCompetency = false;
	/**
	 * Async counter to keep track of number of unresolved processes.
	 *
	 * @property numberOfQueriesRunning
	 * @type integer
	 */
	public int numberOfQueriesRunning;
	/**
	 * Local log for this inquiry packet.
	 *
	 * @property log
	 * @type string
	 */
	public String log;
	/**
	 * Assertions (direct or indirect) that contribute to a positive result.
	 *
	 * @property positive
	 * @type EcAssertion[]
	 */
	public Array<EcAssertion> positive;
	/**
	 * Assertions (direct or indirect) that contribute to a negative result.
	 *
	 * @property negative
	 * @type EcAssertion[]
	 */
	public Array<EcAssertion> negative;
	/**
	 * Set to true if this packet has completed processing.
	 *
	 * @property finished
	 * @type boolean
	 */
	public Boolean finished = false;
	/**
	 * Set to true if this packet has finished stage one.
	 *
	 * @property stageOneFinished
	 * @type boolean
	 */
	public Boolean stageOneComplete = false;
	/**
	 * Type of inquiry packet. Inquiry packets can represent relational logic, rollup logic or competencies.
	 *
	 * @property type
	 * @type IPType
	 */
	public IPType type;
	/**
	 * Rollup Rule search string. (if IPType == ROLLUPRULE)
	 *
	 * @property rule
	 * @type string
	 */
	public String rule;
	/**
	 * Result as a ResultType.
	 *
	 * @property result
	 * @type ResultType
	 */
	public ResultType result;

	/**
	 * Create an InquiryPacket.
	 *
	 * @param {EcPk[]}                  subject Public keys of the individual to retreive assertions about.
	 * @param {EcCompetency}            competency Competency that the inquiry is made about.
	 * @param {EcLevel}                 level Level of the competency.
	 * @param {EcFramework}             context Framework to provide boundaries for the inquiry within.
	 * @param {function(InquiryPacket)} success Method to call when a result has been reached.
	 * @param {function(string)}        failure Method to call if the inquiry fails.
	 * @param {string}                  rule For rollup rules, this is a search used to populate this inquiry packet.
	 * @param {IPType}                  type The type of this inquiry packet. May be competency, rollup rule, or relation.
	 * @constructor
	 */
	public InquiryPacket(Array<EcPk> subject, EcCompetency competency, EcLevel level, EcFramework context, Callback1<InquiryPacket> success,
	                     Callback1<String> failure, String rule, IPType type) {
		positive = new Array<EcAssertion>();
		negative = new Array<EcAssertion>();
		equivalentPackets = new Array<InquiryPacket>();
		subPackets = new Array<InquiryPacket>();
		dateCreated = new Date().getTime();
		this.subject = subject;
		this.competency = new Array<>();
		if (competency != null)
			this.competency.push(competency);

		this.level = new Array<>();
		if (level != null)
			this.level.push(level);
		this.context = context;
		this.success = success;
		this.failure = failure;
		this.rule = rule;
		this.type = type;
		this.result = null;
		log = "";
	}

	public EcFramework getContext() {
		return context;
	}

	/**
	 * Returns true if any child packets have an indeterminate result.
	 *
	 * @return {boolean}
	 * @method anyIndeterminantChildPackets
	 */
	public boolean anyIndeterminantChildPackets() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (ResultType.INDETERMINANT.equals(equivalentPackets.$get(i).result))
				return true;
		}
		for (int i = 0; i < subPackets.$length(); i++) {
			if (ResultType.INDETERMINANT.equals(subPackets.$get(i).result))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if all child packets have unknown results.
	 *
	 * @return {boolean}
	 * @method allChildPacketsUnknown
	 */
	public boolean allChildPacketsUnknown() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (!ResultType.UNKNOWN.equals(equivalentPackets.$get(i).result))
				return false;
		}
		for (int i = 0; i < subPackets.$length(); i++) {
			if (!ResultType.UNKNOWN.equals(subPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if all child packets have unknown results.
	 *
	 * @return {boolean}
	 * @method allChildPacketsUnknown
	 */
	public boolean allChildPacketsAreTrue() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (!ResultType.TRUE.equals(equivalentPackets.$get(i).result))
				return false;
		}
		for (int i = 0; i < subPackets.$length(); i++) {
			if (!ResultType.TRUE.equals(subPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if any child packets have false results.
	 *
	 * @return {boolean}
	 * @method anyChildPacketsAreFalse
	 */
	public boolean anyChildPacketsAreFalse() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (ResultType.FALSE.equals(equivalentPackets.$get(i).result))
				return true;
		}
		for (int i = 0; i < subPackets.$length(); i++) {
			if (ResultType.FALSE.equals(subPackets.$get(i).result))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if any child packets have unknown results.
	 *
	 * @return {boolean}
	 * @method anyChildPacketsAreUnknown
	 */
	public boolean anyChildPacketsAreUnknown() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (ResultType.UNKNOWN.equals(equivalentPackets.$get(i).result))
				return true;
		}
		for (int i = 0; i < subPackets.$length(); i++) {
			if (ResultType.UNKNOWN.equals(subPackets.$get(i).result))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if any child packets have true results.
	 *
	 * @return {boolean}
	 * @method anyChildPacketsAreTrue
	 */
	public boolean anyChildPacketsAreTrue() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (ResultType.TRUE.equals(equivalentPackets.$get(i).result))
				return true;
		}
		for (int i = 0; i < subPackets.$length(); i++) {
			if (ResultType.TRUE.equals(subPackets.$get(i).result))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if all equivalent packets have unknown results.
	 *
	 * @return {boolean}
	 * @method allEquivalentPacketsUnknown
	 */
	public boolean allEquivalentPacketsUnknown() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (!ResultType.UNKNOWN.equals(equivalentPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if all equivalent packets have the true or unknown result.
	 *
	 * @return {boolean}
	 * @method allEquivalentPacketsTrueOrUnknown
	 */
	public boolean allEquivalentPacketsTrueOrUnknown() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (ResultType.FALSE.equals(equivalentPackets.$get(i).result) || ResultType.INDETERMINANT.equals(equivalentPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if all sub packets have the true or unknown result.
	 *
	 * @return {boolean}
	 * @method allSubPacketsTrueOrUnknown
	 */
	public boolean allSubPacketsTrueOrUnknown() {
		for (int i = 0; i < subPackets.$length(); i++) {
			if (ResultType.FALSE.equals(subPackets.$get(i).result) || ResultType.INDETERMINANT.equals(subPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if all equivalent packets have the false or unknown result.
	 *
	 * @return {boolean}
	 * @method allEquivalentPacketsFalseOrUnknown
	 */
	public boolean allEquivalentPacketsFalseOrUnknown() {
		for (int i = 0; i < equivalentPackets.$length(); i++) {
			if (ResultType.TRUE.equals(equivalentPackets.$get(i).result) || ResultType.INDETERMINANT.equals(equivalentPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if all sub packets have the false or unknown result.
	 *
	 * @return
	 */
	public boolean allSubPacketsFalseOrUnknown() {
		for (int i = 0; i < subPackets.$length(); i++) {
			if (ResultType.TRUE.equals(subPackets.$get(i).result) || ResultType.INDETERMINANT.equals(subPackets.$get(i).result))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if the provided ID represents a competency in this packet.
	 *
	 * @param competencyId
	 * @return
	 */
	public boolean hasId(String competencyId) {
		for (int i = 0; i < competency.$length(); i++)
			if (competency.$get(i).isId(competencyId))
				return true;
		return false;
	}

	public enum IPType {
		COMPETENCY, ROLLUPRULE, RELATION_AND, RELATION_OR, RELATION_NARROWS, RELATION_BROADENS, RELATION_REQUIRES, RELATION_ISREQUIREDBY
	}

	public enum ResultType {
		TRUE, FALSE, UNKNOWN, INDETERMINANT
	}

}
