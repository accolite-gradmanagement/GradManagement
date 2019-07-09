import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { TrainerAllocation, Batch } from './RequiredClasses';
import { SharedService } from '../../shared.service';

const dateFormat = 'dd/MM/yyyy';
@Component({
    selector: 'app-view',
    templateUrl: './view.component.html',
    styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
    batches:Batch[];
    oneBatch:Batch;
    sessions:TrainerAllocation[];
    selectedBatch:number;
    var1:boolean=false;
    var2:boolean=false;
    datePipe = new DatePipe('en-US');
    datewiseSessions;
    keysOfDatewiseSessions;
    selectedBatchName:string;
    // datewiseSessions = new Map<string, TrainerAllocation[]>();

    constructor(private service: SharedService) { }
    ngOnInit() {
        this.service.getBatches().subscribe(data=>{
            this.batches=data;
            // console.log(this.batches);
        })
        this.selectedBatch=46;
        this.loadSessions();
    }

    loadSessions()
    {
        console.log(this.selectedBatch);
        // console.log(this.selectedBatch);
        
        // this.batches.forEach(element=>
        //     {
        //         if(this.selectedBatch==element.batchId)
        //         this.selectedBatchName=element.batchName;
        //     });
        this.datewiseSessions = new Map<string, TrainerAllocation[]>();
        this.service.getTimesheetForBatch(this.selectedBatch).subscribe(data=>
            {
                this.oneBatch=data;
                this.sessions=this.oneBatch.trainerAllocation;
                // console.log(this.sessions);
                this.sessions.sort((a: TrainerAllocation, b: TrainerAllocation) => {
                    return <any>new Date(a.start_time) - <any>new Date(b.start_time);
                });
                // console.log(this.sessions);
                
                this.sessions.forEach(element => {
                    if (this.datewiseSessions.has(this.datePipe.transform(element.start_time, dateFormat))) {
                        this.datewiseSessions.get(this.datePipe.transform(element.start_time, dateFormat)).push(element);
                    }
                    else {
                        this.datewiseSessions.set(this.datePipe.transform(element.start_time, dateFormat), [element]);
                    }
                });
                this.keysOfDatewiseSessions=this.datewiseSessions.keys();

                // console.log(this.datewiseSessions.keys());

                if(this.sessions.length!=0)
                {
                    this.var2=false;
                    this.var1=true;
                    console.log(this.keysOfDatewiseSessions);

                }
                else
                {
                    this.var1=false;
                    this.var2=true;
                }

            })    
    }
    public config:any = {
        paging: true,
        filtering: {filterString: ''},
        className: ['table-striped', 'table-bordered']
      };

}
