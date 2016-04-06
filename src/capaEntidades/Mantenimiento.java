package capaEntidades;

import java.util.Calendar;

public class Mantenimiento {
	
	public enum Tipo{
		Arreglo_General,
		Chequeo,
		Pinchaduras,
	}
	
		private Calendar fechaHoraMantenimiento;
		private Calendar fechaHoraIngreso;
		private Calendar fechaHoraEgreso;
		private Tipo tipo;
		private Double kmIngreso;
		private Double kmEgreso;
		private Camion camion;
		
		public Calendar getFechaHoraIngreso() {
			return fechaHoraIngreso;
		}
		public void setFechaHoraIngreso(Calendar fechaHoraIngreso) {
			this.fechaHoraIngreso = fechaHoraIngreso;
		}
		public Calendar getFechaHoraMantenimiento() {
			return fechaHoraMantenimiento;
		}
		public void setFechaHoraMantenimiento(Calendar fechaHoraMantenimiento) {
			this.fechaHoraMantenimiento = fechaHoraMantenimiento;
		}
		public Calendar getFechaHoraEgreso() {
			return fechaHoraEgreso;
		}
		public void setFechaHoraEgreso(Calendar fechaHoraEgreso) {
			this.fechaHoraEgreso = fechaHoraEgreso;
		}
		public Tipo getTipo() {
			return tipo;
		}
		public void setTipo(Tipo tipo) {
			this.tipo = tipo;
		}
		public Double getKmIngreso() {
			return kmIngreso;
		}
		public void setKmIngreso(Double kmIngreso) {
			this.kmIngreso = kmIngreso;
		}
		public Double getKmEgreso() {
			return kmEgreso;
		}
		public void setKmEgreso(Double kmEgreso) {
			this.kmEgreso = kmEgreso;
		}
		public Camion getCamion() {
			return camion;
		}
		public void setCamion(Camion camion) {
			this.camion = camion;
		}

	public Mantenimiento(Calendar fechaHoraMantenimiento,Calendar fechaHoraIngreso,Calendar fechaHoraEgreso,
			Tipo tipo,Double kmIngreso,Double kmEgreso,Camion camion)
	{
		this.fechaHoraMantenimiento=fechaHoraMantenimiento;
		this.fechaHoraIngreso=fechaHoraIngreso;
		this.fechaHoraEgreso=fechaHoraEgreso;
		this.tipo=tipo;
		this.kmIngreso=kmIngreso;
		this.kmEgreso=kmEgreso;
		this.camion=camion;
	};
	
}
