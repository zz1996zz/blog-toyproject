# blog-toyproject

## Description  
회원들의 블로그를 한꺼번에 볼 수 있는 웹페이지.  
블로그 등록 및 블로그 검색, 블로그에 게시글 작성 및 삭제 기능 등이 있다.

## Environment
- Java 11
- Eclipse
- H2 database(2.1.212)
- SpringBoot
- Spring Data JPA
- JSP

## Files
- 블로그 등록, 삭제, 수정
  - 로그인한 회원이 블로그가 없으면 블로그를 등록할 수 있다. 1인 1블로그 정책을 따른다.
  - 블로그 관련 기능은 BlogController 클래스에 구현되어있다.
- 게시글 작성, 삭제, 수정
  - 블로그 내에서 게시글은 여러개 등록할 수 있다.
  - 게시글 등록 및 수정, 삭제는 PostController 클래스에 구현되어있다.
- 카테고리 등록, 삭제, 수정
  - 블로그 내에서 여러 카테고리를 생성할 수 있고, 게시글을 생성할 때, 카테고리를 선택할 수 있다.
  - 카테고리 관련 기능은 CategoryController 클래스에 구현되어있다.

## Usage
- H2 database와 톰캣이 설치되어 있어야한다.
  - 프로젝트 만들 당시 톰캣 9.0 버전을 사용하였다.
- 추가 후에 H2 database가 설치된 위치에 bin폴더안의 h2w.bat파일을 실행시켜 DB 엔진을 실행시킨다.
- H2 database를 실행 후에 src/main/resources의 create_table.sql 파일을 참조하여 프로젝트에 필요한 테이블을 생성한다.
