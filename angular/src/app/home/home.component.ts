import { Component, OnInit } from '@angular/core';

import { ProductService } from '../services/product.service';

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    products: any = [];

	constructor(
        private productService: ProductService
    ) { }

	ngOnInit(): void {
        this.productService.getProducts()
            .subscribe((data) => {
                console.log(data)
                data.forEach(element => {
                    console.log(element)
                    this.products.push(element);
                });
            })
	}

}
