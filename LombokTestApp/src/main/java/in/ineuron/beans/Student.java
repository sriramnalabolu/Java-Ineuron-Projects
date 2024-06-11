package in.ineuron.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
public class Student {
	@NonNull
    private Integer sid;
    private String sname;
    private String saddress;
    private Integer sage;
}

