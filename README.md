# REST API Receitas

```
class Receita {
        -nome: string
        -ingredientes: string[]
        -modo_de_preparo: string[]
        -pais_de_origem: string
    }

    Receita "1" *-- "n" Ingredientes
    Receita "1" *-- "n" Passos

    class Ingredientes {
        -nome: string
    }

    class Passos {
        -descricao: string
    }
```