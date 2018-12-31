import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-overall',
  templateUrl: './overall.component.html',
  styleUrls: ['./overall.component.css']
})
export class OverallComponent implements OnInit {
qcBatchAssess: number;
  constructor() { }

  ngOnInit() {
  }

  // Used to pick face for batch
 pickOverallStatus(batch, pick) {
	// tslint:disable-next-line:indent
	this.qcBatchAssess = pick;
	/*$log.debug(batch.trainingName + " " + pick);
	$log.debug("bnote");
	$log.debug($scope.bnote);*/
	// Set batch note to pick and save it
	//this.bnote.qcStatus = pick;
	//this.saveQCNotes();
};


  /*
	qc.getAssessmentsByBatchId = function(batchId) {
		$log.debug("In assessment");
		return $http({
			url : "/qc/assessment/byBatchId/" + batchId + "/",
			method : "GET"
		}).then(function(response) {
			$log.debug("Assessments retrieved successfully");
			$log.debug(response);
			return response.data;
		}, function(response) {
			$log.error("There was an error: " + response.status);
		});
	};

	// get all assessments
	qc.getAllAssessments = function(weekId) {
		return $http({
			url : "/qc/assessment/byWeek/" + weekId + "/",
			method : "GET"
		}).then(function(response) {
			$log.debug("Assessments retrieved successfully");
			$log.debug(response);
			return response.data;
		}, function(response) {
			$log.error("There was an error: " + response.status);
		});
	};
	// get all assessment categories for the week
	qc.getAllAssessmentCategories = function(batchId, weekId) {
		return $http({
			url : "/all/assessments/categories/batch/" + batchId + "/week/" + weekId + "/",
			method : "GET"
		}).then(function(response) {
			$log.debug("Assessments categories retrieved successfully");
			$log.debug("response");
			return response.data;
		}, function(response) {
			$log.error("There was an error: " + response.status);
		});
  }; */


}
