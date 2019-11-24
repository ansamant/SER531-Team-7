package semanticWeb;
/**
 * Contains Artwork Details that are to be displayed to the user on the UI
 * @author leharbhatt
 *
 */
public class ArtworkDetails {

	private int locationArtworkID;
	private String artworkTitle;
	private String name;
	private String classification;
	private float height;
	private String department;
	private String acquisitionDate;
	private String credit;
	private String dimension;
	private String medium;
	private String creationDate;
	private float width;
	
	private int artistId;
	private String gender;
	private String nationality;
	private int deathYear;
	private int birthYear;
	
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getDeathYear() {
		return deathYear;
	}
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLocationArtworkID() {
		return locationArtworkID;
	}
	public void setLocationArtworkID(int locationArtworkID) {
		this.locationArtworkID = locationArtworkID;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getArtworkTitle() {
		return artworkTitle;
	}
	public void setArtworkTitle(String artworkTitle) {
		this.artworkTitle = artworkTitle;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
}
