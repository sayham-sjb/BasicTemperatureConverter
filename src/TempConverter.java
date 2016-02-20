
public class TempConverter {
		double temp;
		double outTemp = 0;
		public TempConverter(double temp, double outTemp) {
			super();
			this.temp = temp;
			this.outTemp = outTemp;
		}
		
		public TempConverter() {
			// TODO Auto-generated constructor stub
		}

		public double celToKel(double a){
			return outTemp = (a + 273);//Celsius to Kelvin
		}
		
		public double fahToKel(double b){
			return outTemp = ((.55555) * (b - 32) + 273);//Fahrenheit to Kelvin
		}
		
		public double kelToFah(double c){
			return outTemp = (((c - 273) * (1.8)) + 32);//Kelvin to Fahrenheit
		}
		
		public double celToFah(double d){
			return outTemp = (((1.8) * d) + 32);//Celsius to Fahrenheit
		}
		
		public double fahToCel(double e){
			return outTemp = ((.55555) * (e - 32));//Fahrenheit to Celsius
		}
		
		public double kelToCel(double f){
			return outTemp = (f - 273);//Kelvin to Celsius
		}
}
