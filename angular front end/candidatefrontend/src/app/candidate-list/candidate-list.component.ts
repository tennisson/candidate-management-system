import { Component ,OnInit} from '@angular/core';
import {Candidate} from '../candidate';
import { CandidateService } from '../candidate.service'
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.component.html',
  styleUrls: ['./candidate-list.component.css']
})
export class CandidateListComponent implements OnInit {
  candidates: Candidate[] ;
  constructor(private candidateService: CandidateService ,private router: Router) { } 

  ngOnInit(): void {
   this.getCandidates();
  }

  private getCandidates(){
    this.candidateService.getCandidatesList().subscribe(data => {
      this.candidates = data;
    });
  }
 candidateDetails(id: number){
    this.router.navigate(['candidate-details', id]);
  }

  updateCandidate(id: number){
    this.router.navigate(['update-candidate', id]);
  }

  deleteCandidate(id: number){
    this.candidateService.deleteCandidate(id).subscribe( data => {
      console.log(data);
      this.getCandidates();
    })
  }

  }


 

  

