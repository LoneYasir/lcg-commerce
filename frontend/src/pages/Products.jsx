import { useEffect, useState } from "react";
import api from "../services/api";

function Products() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    api.get("/products")
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>Products</h1>

      {products.map((product) => (
        <div
          key={product.id}
          style={{
            border: "1px solid #ddd",
            padding: "15px",
            marginBottom: "15px",
            borderRadius: "10px",
          }}
        >
          <h2>{product.name}</h2>

          <p>{product.description}</p>

          <p>
            <strong>Category:</strong> {product.category?.name}
          </p>

          <p>
            <strong>Brand:</strong> {product.brand}
          </p>

          <p>
            <strong>Price:</strong> ₹{product.price}
          </p>

          <p>
            <strong>Discount Price:</strong> ₹{product.discountPrice}
          </p>

          <p>
            <strong>Stock:</strong> {product.stock}
          </p>

          <p>
            <strong>Color:</strong> {product.color}
          </p>

          <p>
            <strong>Size:</strong> {product.size}
          </p>

          <p>
            <strong>Material:</strong> {product.material}
          </p>
        </div>
      ))}
    </div>
  );
}

export default Products;