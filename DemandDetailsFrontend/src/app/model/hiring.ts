export class Demand {
    constructor(
      public ED_ID: number,
      public ED_NAME: string,
      public HM_ID: number,
      public HM_NAME: string,
      public DEMAND_COUNT: number,
      public START_TIME: number,
      public L_ID: number,
      public STATUS: string,
      public COMMENTS: string
    ){}
}
