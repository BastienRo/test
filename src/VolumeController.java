







public class VolumeController {

	private VolumeModel model = null;
	public FieldVolumeView fieldView = null;
	public XYLineChartExample fieldViewCourbe= null;
	
	/**
	 * Default constructeur
	 */
	public VolumeController (VolumeModel model)
	{
		this.model = model;
	}
	
	
	
	public void init(FieldVolumeView fView)
	{

	this.fieldView = fView;

	}
	public void displayViews() 
	{
		this.fieldView.display();
		
	}
	
	public void closeViews() 
	{
		this.fieldView.close();
		
	}
	
	public void notifyVolumeChanged(int volume){
		this.model.setVolume(volume);
	}
	
	public void initCourbe(XYLineChartExample fView)
	{
		this.fieldViewCourbe =fView;
	}
	
	
}