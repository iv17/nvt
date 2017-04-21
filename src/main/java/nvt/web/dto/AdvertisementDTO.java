package nvt.web.dto;

import java.util.Date;

import nvt.beans.Advertisement;

public class AdvertisementDTO {

	protected int id;
	protected Date posted;
	protected Date updated;
	protected int duration;
	protected boolean inappropriate;
	protected boolean verified;
	protected RealEstateDTO realEstateDTO;
	protected AgentDTO agentDTO;
	protected AdvertisementTypeDTO advertisementTypeDTO;

	
	
	public AdvertisementDTO() {
		
	}
	
	
	public AdvertisementDTO(Advertisement advertisement) {
		id = advertisement.getId();
		posted = advertisement.getPosted();
		updated = advertisement.getUpdated();
		duration = advertisement.getDuration();
		inappropriate = advertisement.isInappropriate(); 
		verified = advertisement.isVerified();
		realEstateDTO = new RealEstateDTO(advertisement.getRealEstate());
		agentDTO = new AgentDTO(advertisement.getAgent());
		advertisementTypeDTO = new AdvertisementTypeDTO(advertisement.getAdvertisementType());
	}

	/*
	 * public AdvertisementDTO(int id, Date posted, Date updated, int duration, boolean inappropriate,
			boolean verified, RealEstateDTO realEstateDTO, AgentDTO agentDTO, AdvertisementTypeDTO advertisementTypeDTO) {
		this.id = id;
		this.posted = posted;
		this.updated = updated;
		this.duration = duration;
		this.inappropriate = inappropriate;
		this.verified = verified;
		this.realEstateDTO = realEstateDTO;
		this.agentDTO = agentDTO;
		this.advertisementTypeDTO = advertisementTypeDTO;
	}
	

	 */
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isInappropriate() {
		return inappropriate;
	}

	public void setInappropriate(boolean inappropriate) {
		this.inappropriate = inappropriate;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public RealEstateDTO getRealEstateDTO() {
		return realEstateDTO;
	}

	public void setRealEstateDTO(RealEstateDTO realEstateDTO) {
		this.realEstateDTO = realEstateDTO;
	}

	public AgentDTO getAgentDTO() {
		return agentDTO;
	}

	public void setAgentDTO(AgentDTO agentDTO) {
		this.agentDTO = agentDTO;
	}

	public AdvertisementTypeDTO getAdvertisementTypeDTO() {
		return advertisementTypeDTO;
	}

	public void setAdvertisementTypeDTO(AdvertisementTypeDTO advertisementTypeDTO) {
		this.advertisementTypeDTO = advertisementTypeDTO;
	}

	
}
