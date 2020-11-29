package Models;

import aquality.appium.mobile.application.AqualityServices;

public class mProject {

    private String name;
    private String percent;
    private String days;
    private String timeUnits;


    public String getTimeUnits() {
        return timeUnits;
    }

    public void setTimeUnits(String timeUnits) {
        if (!timeUnits.contains("days")) {
            this.days = "0";
            AqualityServices.getLogger().warn("Here is a less then 1 day to deadline date. Setting Days = 0.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
            this.days = days;
    }

    @Override
    public String toString() {
        return "mProject{" +
                "name='" + this.name + '\'' +
                ", percent='" + this.percent + '\'' +
                ", days='" + this.days + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mProject mProject = (mProject) o;
        return this.percent.equals(mProject.percent) &&
                this.days.equals(mProject.days);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
