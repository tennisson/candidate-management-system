import { Component,OnInit } from '@angular/core';
import { Candidate } from '../candidate';
import { Router } from '@angular/router';
import { CandidateService } from '../candidate.service';

@Component({
  selector: 'app-create-candidate',
  templateUrl: './create-candidate.component.html',
  styleUrls: ['./create-candidate.component.css']
})
export class CreateCandidateComponent implements OnInit {
  candidate: Candidate = new Candidate();
  constructor(private candidateService: CandidateService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveCandidate(){
    this.candidateService.createCandidate(this.candidate).subscribe( data =>{
      console.log(data);
      this.goToCandidateList();
    },
    error => console.log(error));
  }

  goToCandidateList(){
    this.router.navigate(['/candidates']);
  }
  
  onSubmit(){
    console.log(this.candidate);
    this.saveCandidate();
  }

}
