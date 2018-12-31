package com.revature.caliber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Note;
import com.revature.caliber.dao.BatchRepository;
import com.revature.caliber.dao.NoteRepository;

@Service
public class EvaluationService {
		@Autowired
		NoteRepository note;
		
		@Autowired
		BatchRepository aBatch;
		
		public void CalculateAverage(Integer weekId, Batch batch) {
			if(batch !=  null) {
				Note overallNote = note.fin;
				if(overallNote == null) {
					overallNote = new Note();
					overallNote.setBatchId(batch.batchId);
					overallNote.setWeek(week);
					overallNote.setQcStatus(qcStatus);
					overallNote.setNoteType(noteType);
					overallNote.setMaxVisibility(maxVisibility);
					overallNote.setQcFeedback(qcFeedback);
					note.save(overallNote);
				}
			}
		}
}
