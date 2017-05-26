package com.huios.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Conseiller;
import com.huios.metier.Gerant;
import com.huios.service.IServiceGerant;

@Controller
@SessionScope
public class ChartView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7328243352227307459L;

	private PieChartModel pieModel1;
	private PieChartModel pieModel2;

	@Autowired
	private Gerant ger;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		createPieModel1();
		createPieModel2();
	}

	private void createPieModel1() {
		// Collection<Conseiller> conseillers = new ArrayList<>();
		// conseillers = iserv.listerConseillerParGerant(gerant);

		pieModel1 = new PieChartModel();

		pieModel1.set("Conseiller 1", 540);
		pieModel1.set("Conseiller 2", 325);
		pieModel1.set("Conseiller 3", 702);
		pieModel1.set("Conseiller 4", 421);

		pieModel1.setTitle("Graphique de performance des conseillers");
		pieModel1.setLegendPosition("w");
	}

	private void createPieModel2() {
		pieModel2 = new PieChartModel();

		pieModel2.set("Conseiller 1", 540);
		pieModel2.set("Conseiller 2", 325);
		pieModel2.set("Conseiller 3", 702);
		pieModel2.set("Conseiller 4", 421);

		pieModel2.setTitle("graph exprimé en pourcentage");
		pieModel2.setLegendPosition("e");
		pieModel2.setFill(false);
		pieModel2.setShowDataLabels(true);
		pieModel2.setDiameter(150);
	}

	public void creationGerant(Gerant gerant) {
		System.out.println(gerant.getNom());
		GerantBean gb = new GerantBean();
		System.out.println(gerant.getNom());
		gb.pie();

	}

}