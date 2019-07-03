import { Pipe, PipeTransform } from '@angular/core';
import { Grad } from 'src/app/gradManagement/gradmanagement/Grad';

@Pipe({ name: 'search' })
export class SearchPipe implements PipeTransform {
  transform(grads: Grad[], nameSearch: string, empCodeSearch: string) {

      // return grads.filter(grad => grad.name.toLowerCase().indexOf(searchText.toLowerCase()) !== -1);
      if (grads && grads.length){
        return grads.filter(grad =>{
            if (nameSearch && grad.name.toLowerCase().indexOf(nameSearch.toLowerCase()) === -1){
                return false;
            }
            if (empCodeSearch && grad.employeeCode.toLowerCase().indexOf(empCodeSearch.toLowerCase()) === -1){
                return false;
            }
            
            return true;
       })
      }
      else{
        return grads;
      }
  }
}

