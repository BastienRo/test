

import java.util.Observable;

public class VolumeModel extends Observable{
	

	private int volume;
	public VolumeModel() {
	  this.volume = 0;
	}
	/**
	 * @return the volume
	 */
	public int getVolume() {
	  return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
	  this.volume = volume;
	  setChanged();
	  notifyObservers(this.volume);
	}
}