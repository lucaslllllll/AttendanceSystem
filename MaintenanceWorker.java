public class MaintenanceWorker extends Person {

        private String workArea; 
    
        public MaintenanceWorker(String name, int id, String workArea) {
            super(name, id); 
            this.workArea = workArea;
        }
    
        public String getWorkArea() {
            return workArea;
        }
    
        public void setWorkArea(String workArea) {
            this.workArea = workArea;
        }
    
        @Override
        public String toString() {
            return super.toString() + " - Work Area: " + workArea;
        }
    }
