package smartspace.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import smartspace.dao.rdb.MapToJsonConverter;

@Entity
@Table(name="ACTIONS")
public class ActionEntity implements SmartspaceEntity<String> {

	private String actionSmartspace;
	private String actionId;
	private String elementSmartspace;
	private String elementId;
	private String playerSmartspace;
	private String playerEmail;
	private String actionType;
	private Date creationTimestamp;
	private Map<String, Object> moreAttributes;
	
	
	public ActionEntity() {
		//to delete
		this.creationTimestamp = new Date();
		//to delete
		this.moreAttributes = new HashMap<>();
	}
	
	//to delete!!
	public ActionEntity(String type) {
		this();
		this.actionType = type;
	}
	
	public ActionEntity( String elementSmartSpace, String elementId,
			String playerSmartspace, String playerEmail, String actionType, Date creationTimestamp,
			Map<String, Object> moreAttributes) {
		super();
		this.elementSmartspace = elementSmartSpace;
		this.elementId = elementId;
		this.playerSmartspace = playerSmartspace;
		this.playerEmail = playerEmail;
		this.actionType = actionType;
		this.creationTimestamp = creationTimestamp;
		this.moreAttributes = moreAttributes;
	}
	
	//to check
	public ActionEntity(String actionSmartspace, String actionId, String elementSmartspace, String elementId,
			String playerSmartspace, String playerEmail, String actionType, Date creationTimestamp,
			Map<String, Object> moreAttributes) {
		super();
		this.actionSmartspace = actionSmartspace;
		this.actionId = actionId;
		this.elementSmartspace = elementSmartspace;
		this.elementId = elementId;
		this.playerSmartspace = playerSmartspace;
		this.playerEmail = playerEmail;
		this.actionType = actionType;
		this.creationTimestamp = creationTimestamp;
		this.moreAttributes = moreAttributes;
	}

	@Transient
	public String getActionSmartspace() {
		return actionSmartspace;
	}

	public void setActionSmartspace(String actionSmartspace) {
		this.actionSmartspace = actionSmartspace;
	}
	
	@Transient
	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getElementSmartspace() {
		return elementSmartspace;
	}

	public void setElementSmartspace(String elementSmartspace) {
		this.elementSmartspace = elementSmartspace;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getPlayerSmartspace() {
		return playerSmartspace;
	}

	public void setPlayerSmartspace(String playerSmartspace) {
		this.playerSmartspace = playerSmartspace;
	}

	public String getPlayerEmail() {
		return playerEmail;
	}

	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	@Lob
	@Convert(converter=MapToJsonConverter.class)
	public Map<String, Object> getMoreAttributes() {
		return moreAttributes;
	}

	public void setMoreAttributes(Map<String, Object> moreAttributes) {
		this.moreAttributes = moreAttributes;
	}

	@Override
	@Id
	@Column(name="ID")
	public String getKey() {
		return this.actionSmartspace + "=" + this.actionId;
	}

	@Override
	public void setKey(String key) {
		String[] split = key.split("=");
		if(split!=null & split.length==2) {
			this.actionSmartspace = split[0];
			this.actionId = split[1];	
		}
	}

	@Override
	public String toString() {
		return "ActionEntity [actionSmartspace=" + actionSmartspace + ", actionId=" + actionId + ", elementSmartSpace="
				+ elementSmartspace + ", elementId=" + elementId + ", playerSmartspace=" + playerSmartspace
				+ ", playerEmail=" + playerEmail + ", actionType=" + actionType + ", creationTimestamp="
				+ creationTimestamp + ", moreAttributes=" + moreAttributes + "]";
	}
	
}
