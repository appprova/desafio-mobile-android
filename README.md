# Desafio de programação mobile Android

A ideia deste desafio é nos permitir avaliar melhor as habilidades de candidatos a vagas de programador, de vários níveis.

Este desafio deve ser feito por você em sua casa. Gaste o tempo que você quiser, porém normalmente você não deve precisar de mais do que algumas horas.


## Ferramentas

Android Studio 3.0 RC2

Android SDK


Utilizei os seguintes padrões:

Delimitador de fim de linha: UNIX (LF ou \n)

Codificação de arquivos: UTF-8

Indentação: 4 espaços


## Referência API

https://developer.github.com/v3/


## Arquitetura

com.felipemiranda.desafioappprova

MVP


## Dependências

ButterKnife 8.8.1

Facilita o trabalho de encontrar e ligar Views com membros de uma classe, sem a necessidade de se fazer casts e findViewById(int), utilizando anotações.

Gson 2.8.2

Serialização e desserialização de POJOs em formato JSON.

Retrofit 2.3.0

Um cliente HTTP para Java e Android que facilita a escrita de chamadas de APIs RESTful.

Android Support 26.1.0

Bibliotecas da Google que oferecem retrocompatibilidade de versões do Android. Neste projeto, estamos utilizando:

MultiDex 1.0.2

Okhttp 3.8.1

Fresco 1.3.0


*build.gradle*

Observe que utilizei o build.gradle para gerenciar o número de versão de algumas dependências, como as bibliotecas android-support e play-services. Isso nos ajuda a manter todas as dependências nas versões corretas.
