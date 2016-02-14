package com.zhenmei.testgson.bean;

import java.util.List;

public class Joke {

    private List<DetailEntity> detail;

    public void setDetail(List<DetailEntity> detail) {
        this.detail = detail;
    }

    public List<DetailEntity> getDetail() {
        return detail;
    }

    public class DetailEntity {
        private int id;
        private String author;
        private String content;
        private String picUrl;

        public void setId(int id) {
            this.id = id;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public int getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        public String getPicUrl() {
            return picUrl;
        }

        @Override
        public String toString() {
            return "DetailEntity{" +
                    "id=" + id +
                    ", author='" + author + '\'' +
                    ", content='" + content + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    '}';
        }
    }

}
