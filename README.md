# Category Feature Slice
    
    
### Requerimentos

- deve fornecer array contendo o primeiro nível de categoria do marketplace
- elementos do array tem as seguintes propriedades:
    - id
    - nome
- deve fornecer categoria por id no formato especificado
- objeto de categoria tem as seguintes propriedades:
    - id
    - nome
    - array de subcategorias
        - objetos de subcategoria tem as seguintes propriedades
            - id
            - nome

### Constraints:

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

### Novos requerimentos:

- muda o modelo dos recursos fornecidos pela API externa

### New external API constraints:

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

“/api/category?parentCategoryCode=56” GET

```json
{
	"page_number": 1,
	"total_records": 2,
	"elements": [
		{
			"code": 43,
			"description": "Cat C",
			"parent_category_code": 56
		},
		{
			"code": 98,
			"description": "Cat D",
			"parent_category_code": 56
		}
	]
}
```

“/api/category?parentCategoryCode=null” GET

```json
{
	"error": "invalid argument"
}
```

- deve disponibilizar endpoint rest para obter este conteudo por uma API

### My API:

“/api/categories” GET

```json
[
  {
    "codeInMarketplace": "56",
    "name": "Cat A"
	},
	{
	  "codeInMarketplace": "112",
	  "name": "Cat B"
	},
	{
	  "codeInMarketplace": "43",
	  "name": "Cat C"
	}
]
```

“/categories/{codeInMarketPlace}” GET

```json
{
  "codeInMarketPlace": "56",
  "name": "Cat A",
  "children": [
    {
      "codeInMarketplace": "43",
      "name": "Cat B"
    },
    {
      "codeInMarketplace": "98",
      "name": "Cat D"
    }
  ]
}
```
