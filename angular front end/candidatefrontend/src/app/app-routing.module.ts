import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CandidateListComponent } from './candidate-list/candidate-list.component';
import { CreateCandidateComponent } from './create-candidate/create-candidate.component';
import { UpdateCandidateComponent } from './update-candidate/update-candidate.component';
import { CandidateDetailsComponent } from './candidate-details/candidate-details.component';



const routes: Routes = [
  {path: 'candidates', component: CandidateListComponent},
  {path: 'create-candidate', component: CreateCandidateComponent},
  {path: '', redirectTo: 'candidates', pathMatch: 'full'},
  {path: 'update-candidate/:id', component: UpdateCandidateComponent},
   {path: 'candidate-details/:id', component: CandidateDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
