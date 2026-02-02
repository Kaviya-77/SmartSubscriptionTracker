package notifysys.SubscriptionNotifySystem.dto;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequest {
	
	    private String name;
	    private Double amount;
	    private String expiryDate;

}

