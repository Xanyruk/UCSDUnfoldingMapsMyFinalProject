package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(PointFeature feature) {
		super(feature.getLocation(), feature.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		
		// Save previous drawing style
				pg.pushStyle();
				
		// IMPLEMENT: drawing triangle for each airport		
		pg.fill(18, 173, 42);
		pg.ellipse(x, y, 8, 8);
		
		// Restore previous drawing style
				pg.popStyle();
		
		
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) 
	{
		String name = getCity() + " " + getCountry() + " ";
		
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(name) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(name, x + 3 , y +18);
		
		
		pg.popStyle();
	}
	
	public String getCity()
	{
		return getStringProperty("name");
	}
	
	public String getCountry()
	{
		return getStringProperty("country");
	}
	
	
}
