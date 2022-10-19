package edu.eci.arsw.collabpaint;


import edu.eci.arsw.collabpaint.model.Polygon;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import edu.eci.arsw.collabpaint.model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;


@Controller

public class STOMPMessagesHandler {
	
	@Autowired
	SimpMessagingTemplate msgt;
    
	@MessageMapping("/newpoint.{numdibujo}")    
	public void handlePointEvent(Point pt,@DestinationVariable String numdibujo) throws Exception {
		System.out.println("Nuevo punto recibido en el servidor!:"+pt);
		msgt.convertAndSend("/topic/newpoint"+numdibujo, pt);
	}

	@MessageMapping("/polygon.{numdibujo}")
	public void handlePolygonEvent(Polygon polygon, @DestinationVariable String numdibujo) throws Exception {
		System.out.println("Nuevo poligono recibido en el servidor!:"+polygon);
		for (Point pt : polygon.getPoints()){
			msgt.convertAndSend("/topic/newpoint" + numdibujo, pt);
		}
	}
}