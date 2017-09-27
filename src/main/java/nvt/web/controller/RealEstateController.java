package nvt.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.LatLng;

import nvt.beans.AdvertisementType;
import nvt.beans.HeatingType;
import nvt.beans.Image;
import nvt.beans.IndoorFeature;
import nvt.beans.Location;
import nvt.beans.OutdoorFeature;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;
import nvt.beans.RealEstateType;
import nvt.service.AdvertisementTypeService;
import nvt.service.HeatingTypeService;
import nvt.service.ImageService;
import nvt.service.IndoorFeatureService;
import nvt.service.LocationService;
import nvt.service.OutdoorFeatureService;
import nvt.service.RealEstateCommentService;
import nvt.service.RealEstateIndoorsService;
import nvt.service.RealEstateOutdoorsService;
import nvt.service.RealEstateRatingService;
import nvt.service.RealEstateReportService;
import nvt.service.RealEstateService;
import nvt.service.RealEstateTypeService;
import nvt.util.Util;
import nvt.web.dto.AddRealEstateDTO;
import nvt.web.dto.BlockDTO;
import nvt.web.dto.CityDTO;
import nvt.web.dto.IndoorFeatureDTO;
import nvt.web.dto.LatLngDTO;
import nvt.web.dto.OutdoorFeatureDTO;
import nvt.web.dto.RealEstateCommentDTO;
import nvt.web.dto.RealEstateDTO;
import nvt.web.dto.SearchDTO;
import nvt.web.dto.SelectedAdvertisementTypeDTO;
import nvt.web.dto.SelectedIndoorFeatureDTO;
import nvt.web.dto.SelectedOutdoorFeatureDTO;
import nvt.web.dto.SelectedRealEstateTypeDTO;
import nvt.web.dto.ZipCodeDTO;

@RestController
@RequestMapping(value = "api/realEstates")
public class RealEstateController {

	@Autowired
	protected RealEstateService realEstateService;

	@Autowired
	protected RealEstateTypeService realEstateTypeService;

	@Autowired
	protected RealEstateCommentService realEstateCommentService;

	@Autowired
	protected RealEstateRatingService realEstateRatingService;

	@Autowired
	protected RealEstateReportService realEstateReportService;

	@Autowired 
	protected LocationService locationService;

	@Autowired
	protected HeatingTypeService heatingTypeService;
	
	@Autowired
	protected ImageService imageService;
	
	@Autowired
	protected AdvertisementTypeService advertisementTypeService;
	
	@Autowired
	protected IndoorFeatureService indoorFeatureService;

	@Autowired
	protected OutdoorFeatureService outdoorFeatureService;
	
	@Autowired
	protected RealEstateIndoorsService indoorsService;
	
	@Autowired
	protected RealEstateOutdoorsService outdoorsService;
	
	@RequestMapping(
			value = "/search",
			method = RequestMethod.POST
			)
	public ResponseEntity<List<RealEstateDTO>> search(@RequestBody SearchDTO searchDTO) {

	
		ArrayList<ZipCodeDTO> selectedZipCodes = new ArrayList<>();
		ArrayList<CityDTO> selectedCities = new ArrayList<>();
		ArrayList<BlockDTO> selectedBlocks = new ArrayList<>();
		ArrayList<SelectedAdvertisementTypeDTO> selectedAdvertisementTypes = new ArrayList<>();
		ArrayList<SelectedRealEstateTypeDTO> selectedRealEstateTypes = new ArrayList<>();
		
		double minPrice = -1;
		double maxPrice = -1;
		double minSurface = -1;
		double maxSurface = -1;
		
		if(searchDTO.getSelectedZipCodes() != null) {
			selectedZipCodes = searchDTO.getSelectedZipCodes();
		}
		if(searchDTO.getSelectedCities() != null) {
			selectedCities = searchDTO.getSelectedCities();
		}
		if(searchDTO.getSelectedBlocks() != null) {
			selectedBlocks = searchDTO.getSelectedBlocks();
		}
		if(searchDTO.getSelectedAdvertisementTypes() != null) {
			selectedAdvertisementTypes = searchDTO.getSelectedAdvertisementTypes();
		}
		if(searchDTO.getSelectedRealEstateTypes() != null) {
			selectedRealEstateTypes = searchDTO.getSelectedRealEstateTypes();
		}
		if(searchDTO.getMinPrice() != -1) { minPrice = searchDTO.getMinPrice(); }
		if(searchDTO.getMaxPrice() != -1) { maxPrice = searchDTO.getMaxPrice(); }
		if(searchDTO.getMinSurface() != -1) { minSurface = searchDTO.getMinSurface(); }
		if(searchDTO.getMaxSurface() != -1) { maxSurface = searchDTO.getMaxSurface(); }

		
		List<RealEstate> realEstates = realEstateService.findAll();
		List<RealEstate> searches = new ArrayList<>();
		for (RealEstate  r : realEstates) {
			
			if(selectedAdvertisementTypes.size() != 0) {
				for (SelectedAdvertisementTypeDTO a : selectedAdvertisementTypes) {
					if(r.getAdvertisementType().getName().equals(a.getLabel())) {
						if(selectedRealEstateTypes.size() != 0) {
							for (SelectedRealEstateTypeDTO s : selectedRealEstateTypes) {
								if(r.getRealEstateType().getName().equals(s.getLabel())) {
									if(selectedZipCodes.size() != 0) {
										for (ZipCodeDTO z : selectedZipCodes) {
											if(r.getLocation().getZipCode().equals(z.getLabel())) {
												if(selectedCities.size() != 0) {
													for (CityDTO c : selectedCities) {
														if(r.getLocation().getCity().equals(c.getLabel())) {
															if(selectedBlocks.size() != 0) {
																for (BlockDTO b : selectedBlocks) {
																	if(r.getLocation().getBlock().equals(b.getLabel())) {
																		if(minPrice != -1 && maxPrice != -1 && minPrice < maxPrice && minPrice <= r.getPrice() && r.getPrice() <= maxPrice) {
																			if(minSurface != -1 && maxSurface != -1 && minSurface < maxSurface && minSurface <= r.getSurface() && r.getSurface() <= maxSurface) {
																
																				searches.add(r);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		
		}
		List<RealEstateDTO> realEstatesDTO = toDTO(searches);
		return new ResponseEntity<List<RealEstateDTO>>(realEstatesDTO, HttpStatus.OK);

	}

	@RequestMapping(
			value = "/add",
			method = RequestMethod.POST
			)
	public ResponseEntity<RealEstateDTO> createRealEstate(@RequestBody AddRealEstateDTO realEstateDTO) {

		
		RealEstate realEstate = new RealEstate();
		realEstate.setName(realEstateDTO.getName());
		realEstate.setDescription(realEstateDTO.getDescription());
		realEstate.setPrice(realEstateDTO.getPrice());
		realEstate.setSurface(realEstateDTO.getSurface());
		realEstate.setFloor(realEstateDTO.getFloor());
		realEstate.setRooms(realEstateDTO.getRooms());
		realEstate.setBathrooms(realEstateDTO.getBathrooms());
		if(realEstateDTO.getFiled().equals("true")) {
			realEstate.setFiled(true);
		} else {
			realEstate.setFiled(false);
		}
		if(realEstateDTO.getFurnished().equals("true")) {
			realEstate.setFurnished(true);
		} else {
			realEstate.setFurnished(false);
		}
		
		realEstate.setConstructedYear(realEstateDTO.getConstructedYear());
		
		
		RealEstateType realEstateType = realEstateTypeService.findById(realEstateDTO.getSelectedRealEstateTypes().get(0).getId());
		if(realEstateType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setRealEstateType(realEstateType);
		
		HeatingType heatingType = heatingTypeService.findById(realEstateDTO.getSelectedHeatingTypes().get(0).getId());
		if(heatingType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setHeatingType(heatingType);
		
		realEstate.setPosted(new Date());
		realEstate.setUpdated(new Date());
		realEstate.setDuration(0);
		realEstate.setInappropriate(false);
		realEstate.setVerified(true);
		
		AdvertisementType  advertisementType = advertisementTypeService.findById(realEstateDTO.getSelectedAdvertisementTypes().get(0).getId());
		if(advertisementType == null) {
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		realEstate.setAdvertisementType(advertisementType);
		
		ArrayList<Double> latlng = realEstateDTO.getLatlng(); 
		double lat = latlng.get(0);
		double lng = Util.round(latlng.get(1), 7);
		
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setLocation(new LatLng(String.valueOf(lat), String.valueOf(latlng.get(1)))).setLanguage("en").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		
		
		Location location = new Location();
		location.setCoord1(lat);
		location.setCoord2(lng);

		location.setStreet(geocoderResponse.getResults().get(0).getFormattedAddress().split(",")[0]);
		location.setCity(geocoderResponse.getResults().get(0).getFormattedAddress().split(",")[1]);
		location.setBlock(geocoderResponse.getResults().get(1).getFormattedAddress().split(",")[0]);
		locationService.save(location);
		
		realEstate.setLocation(location);
		
		ArrayList<SelectedIndoorFeatureDTO> is = realEstateDTO.getSelectedIndoors();
		Set<RealEstateIndoors> indoors = new HashSet<RealEstateIndoors>();
		for (SelectedIndoorFeatureDTO selectedIndoorFeatureDTO : is) {
			IndoorFeature i = indoorFeatureService.findById(selectedIndoorFeatureDTO.getId());
			RealEstateIndoors ii = new RealEstateIndoors();
			ii.setIndoorFeature(i);
			
			indoors.add(ii);
		}
		realEstate.setIndoors(indoors);
		
		ArrayList<SelectedOutdoorFeatureDTO> of = realEstateDTO.getSelectedOutdoors();
		Set<RealEstateOutdoors> outdoors = new HashSet<RealEstateOutdoors>();
		for (SelectedOutdoorFeatureDTO selectedOutdoorFeatureDTO : of) {
			OutdoorFeature o = outdoorFeatureService.findById(selectedOutdoorFeatureDTO.getId());
			RealEstateOutdoors oo = new RealEstateOutdoors();
			oo.setOutdoorFeature(o);
			
			outdoors.add(oo);
		}
		realEstate.setOutdoors(outdoors);
		
		
		RealEstateDTO newRealEstateDTO = new RealEstateDTO(realEstate);
		realEstateService.save(realEstate);
		

		ArrayList<String> names = realEstateDTO.getImages();
		for (String string : names) {
			String file = "app/images/markers/" + string;
			Image im = new Image(string, file.getBytes());
			im.setRealEstate(realEstate);
			imageService.save(im);	
		}
		
		
		for (RealEstateIndoors realEstateIndoors : indoors) {
			realEstateIndoors.setRealEstate(realEstate);
			indoorsService.save(realEstateIndoors);
		}
		for (RealEstateOutdoors realEstateOutdoors : outdoors) {
			realEstateOutdoors.setRealEstate(realEstate);
			outdoorsService.save(realEstateOutdoors);
		}
		
		
		return new ResponseEntity<RealEstateDTO>(newRealEstateDTO, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateDTO>> getRealEstates() {

		List<RealEstate> realEstates = realEstateService.findAll();

		List<RealEstateDTO> realEstateDTOs = toDTO(realEstates);

		return new ResponseEntity<List<RealEstateDTO>>(realEstateDTOs, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RealEstateDTO> getRealEstate(@PathVariable Integer id){

		RealEstate realEstate = realEstateService.findById(id);
		if(realEstate == null){
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);

		return new ResponseEntity<RealEstateDTO>(realEstateDTO, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/latlng", method = RequestMethod.POST)
	public ResponseEntity<RealEstateDTO> getRealEstateLatLng(@RequestBody LatLngDTO latlng){

		
		double lat = latlng.getLat();
		double lng = Util.round(latlng.getLng(), 7);
		
		Location location = locationService.findByCoordinates(lat, lng).get(0);
		RealEstate realEstate = realEstateService.findByLocation(location).get(0);
		if(realEstate == null){
			return new ResponseEntity<RealEstateDTO>(HttpStatus.NOT_FOUND);
		}
		RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);

		return new ResponseEntity<RealEstateDTO>(realEstateDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/indoors", method = RequestMethod.GET)
	public ResponseEntity<List<IndoorFeatureDTO>> getIndoors(@PathVariable Integer id){

		RealEstate realEstate = realEstateService.findById(id);
		if(realEstate == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<IndoorFeatureDTO> indoors = new ArrayList<>();
		for (RealEstateIndoors realEstateIndoors : realEstate.getIndoors()) {
			IndoorFeatureDTO f = new IndoorFeatureDTO(realEstateIndoors.getIndoorFeature());
			indoors.add(f);
		}
		
		return new ResponseEntity<List<IndoorFeatureDTO>>(indoors, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/outdoors", method = RequestMethod.GET)
	public ResponseEntity<List<OutdoorFeatureDTO>> getOutdoors(@PathVariable Integer id){

		RealEstate realEstate = realEstateService.findById(id);
		if(realEstate == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<OutdoorFeatureDTO> outdoors = new ArrayList<>();
		for (RealEstateOutdoors realEstateOutdoors : realEstate.getOutdoors()) {
			OutdoorFeatureDTO f = new OutdoorFeatureDTO(realEstateOutdoors.getOutdoorFeature());
			outdoors.add(f);
		}
		
		return new ResponseEntity<List<OutdoorFeatureDTO>>(outdoors, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
	public ResponseEntity<List<RealEstateCommentDTO>> getComments(@PathVariable Integer id){

		RealEstate realEstate = realEstateService.findById(id);
		if(realEstate == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<RealEstateCommentDTO> comments = new ArrayList<RealEstateCommentDTO>();
		for (RealEstateComment c : realEstate.getComments()) {
			RealEstateCommentDTO cc = new RealEstateCommentDTO(c);
			comments.add(cc);
		}
		
		return new ResponseEntity<List<RealEstateCommentDTO>>(comments, HttpStatus.OK);
	}


	public List<RealEstateDTO> toDTO(List<RealEstate> realEstates) {

		List<RealEstateDTO> realEstateDTOs = new ArrayList<RealEstateDTO>();
		for (RealEstate realEstate : realEstates) {
			RealEstateDTO realEstateDTO = new RealEstateDTO(realEstate);
			realEstateDTOs.add(realEstateDTO);
		}

		return realEstateDTOs;
	}

	
	
}
