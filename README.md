# oohaY!
Sistema em Java de indexação e busca de palavras em arquivos

[img here]

O **oohaY!** foi desenvolvido por Maradona Morais e Daniel Marx como projeto requisito da avaliação da 3º unidade das disciplinas Linguagem de Programação II e Estruturas de Dados Básicas II. As features desenvolvidas no sistema são:

- Indexação, através de interface gráfica, de arquivos
  - Apresentando lista de arquivos indexados
  - Permite remoção de um arquivo indexado
  - Permite atualização de um arquivo já existente
- Busca por palavras
- Recurso de `autocorrect` no sistema de busca que sugere palavras caso nenhuma foi encontrada (similar ao conhecido "Você quis dizer ____ ?" do Google. Recurso desenvolvido utilizando o algoritmo da distância de Levenshtein
- Persistência das informações carregadas, o usuário pode fechar o sistema e quando abrir novamente, os arquivos e palavras indexadas continuarão existindo.
