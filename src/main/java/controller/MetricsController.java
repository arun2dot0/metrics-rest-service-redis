package controller;

import java.util.List;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import db.RedisResource;
import model.Metric;
import pubnub.MessagingService;
import service.MetricService;


@Controller
@RequestMapping
public class MetricsController {

	@Autowired
	MetricService metricService;
	
	@Autowired
	MessagingService messagingService;
	/* 
	 * add with sample payload 
	 * 
	{
	  "temperature": 66,
	  "humidity": 22,
	  "lightintensity": 150,
	  "soundIntensity": 500
	}
	 */
	 @PostMapping("/metrics")
	 public  @ResponseBody String addMetrics(@RequestBody Metric metric  ) {
		 metricService.addMetrics(metric);
		 return "Success";
	 }
	 
	 @GetMapping("/metrics")
	 public  @ResponseBody Metric getMetrics(@RequestParam(value="type", required=false, defaultValue="current") String type ) {
		
		 if(type.equals("average"))
			 return metricService.getAverageMetric();
		 else
			 return metricService.getCurrentMetric();
	 }
	 

	 	 
	
	 
	 @PutMapping("/light")
	 public  @ResponseBody String lighton( @RequestParam(value="opt", required=false, defaultValue="off") String opt ) {
		 messagingService.sendMessage(opt);
		 return  "Light is turned "+ opt;
	 }
	 
	 @PutMapping("/camera")
	 public  @ResponseBody String cameraOperation( @RequestParam(value="opt", required=false, defaultValue="take") String opt ) {
		 messagingService.sendMessage(opt);
		 return  "Message sent to Take Picture and sent to your email.. ";
	 }
	
    

}
