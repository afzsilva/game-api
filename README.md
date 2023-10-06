# game-api
Projeto de estudo para o programa de desafio do DIO

## Diagrama de classes

```mermaid
classDiagram
  class Game {
    + title: string
    + description: string
    + imageUrl: string
    + releaseDate: date
    + developerId: Developer
    + category: Category
    + platform: Platform
  }

  class Developer {
    + id: int
    + title: string
  }

  class Category {
    + id: int
    + title: string
  }

  class Platform {
    + id: int
    + title: string
  }

  Game "1"--|>"1" Developer: developerId
  Game "1"--|>"1" Category: category
  Game "1"--|>"1" Platform: platform

