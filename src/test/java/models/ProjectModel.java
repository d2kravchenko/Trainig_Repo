package models;

import aquality.appium.mobile.application.AqualityServices;
import lombok.*;

@ToString
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"name", "timeUnits"})
public class ProjectModel {

    @Getter @Setter  private String name, percent, days;
    @Getter          private String timeUnits;

    public void setTimeUnits(String timeUnits) {
        if (!timeUnits.contains("days")) {
            this.days = "0";
            AqualityServices.getLogger().warn("Here is a less then 1 day to deadline date. Setting Days = 0.");
        }
    }
}
