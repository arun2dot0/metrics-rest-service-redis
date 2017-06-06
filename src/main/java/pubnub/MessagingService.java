package pubnub;

import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;

@Component
public class MessagingService {
	 PubNub pubnub;
	
	@PostConstruct()
	public void init() {
		PNConfiguration pnConfiguration = new PNConfiguration();

		pnConfiguration.setSubscribeKey("pubnub-subscribekey");
		pnConfiguration.setPublishKey("pubnub-publishkeykey");
		//GET publish subscribe key from pubnub.com
		pubnub = new PubNub(pnConfiguration);
	}
	    
	   
	   
	
	
	public void sendMessage(String message) {
    	
    		pubnub.publish().channel("iot").message(message).async(new PNCallback<PNPublishResult>() {
                @Override
                public void onResponse(PNPublishResult result, PNStatus status) {
                    // Check whether request successfully completed or not.
                    if (!status.isError()) {
                    	System.out.println("Message Sent");
                        // Message successfully published to specified channel.
                    }
                    // Request processing failed.
                    else {
                    	System.out.println("Message Error !!");
                        // Handle message publish error. Check 'category' property to find out possible issue
                        // because of which request did fail.
                        //
                        // Request can be resent using: [status retry];
                    }
                }
            });
    
    	
		
	}

}
