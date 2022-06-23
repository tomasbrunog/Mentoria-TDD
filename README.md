# Mentoria-TDD

Requerimentos

- deve fornecer array contendo o primeiro nível de categoria do marketplace no formato especificado
- deve disponibilizar endpoint rest para obter este conteudo
- deve fornecer categoria por id no formato especificado
- deve disponibilizar endpoint rest para categoria por id
    - gerencia caso item não encontrado
    

Constraints:

My API:

“/api/categories” GET

```json
[
  {
    "codeInMarketplace": "2551",
    "name": "Decoração"
  }
]
```

“/categories/{codeInMarketPlace}” GET

```json
{
  "codeInMarketPlace": 2551,
  "name": "Beleza e Perfumaria",
  "children": [
    {
      "codeInMarketplace": 2554,
      "name": "Maquiagem"
    },
    {
      "codeInMarketplace": 2555,
      "name": "Perfumes"
    }
  ]
}
```

Their API:

“/api/category?pageNumber=1” GET

```json
{
	"page_number": 1,
	"total_records": 3,
	"elements": [
		{
			"code": 56,
			"description": "Cat A"
		},
		{
			"code": 112,
			"description": "Cat B"
		}
	]
}
```

“api/category?code=56” GET

```json
{
	"code": 56,
	"description": "Cat A",
	"subcategories": [
		{
			"code":43,
			"description": "Cat C"
		},
		{
			"code": 98,
			"description": "Cat D"
		}
	]
}
```

- Futuros requerimentos:
    - muda o modelo dos recursos fornecidos pela API externa:
    
    “api/category?code=43” GET
    
    ```json
    {
    	"code": 43,
    	"description": "Cat C",
    	"parent_category_code": 56
    }
    ```
    
    “/api/category?pageNumber=1” GET
    
    ```json
    {
    	"page_number": 1,
    	"total_records": 3,
    	"elements": [
    		{
    			"code": 56,
    			"description": "Cat A",
    			"parent_category_code": null
    		},
    		{
    			"code": 112,
    			"description": "Cat B",
    			"parent_category_code": 23
    		}
    	]
    }
    ```
