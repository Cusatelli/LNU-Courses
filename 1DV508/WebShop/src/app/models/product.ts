export interface Product {
    key: string;
    title: string; 
    price: number; 
    category: string;
    imageUrl: string;
    stock: number;
    rating: number;
    numberOfVotes: number;
    quantity: number;
    dealOfDay: boolean;
    reducedPrice: number;
}
