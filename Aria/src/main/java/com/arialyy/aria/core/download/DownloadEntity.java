/*
 * Copyright (C) 2016 AriaLyy(https://github.com/AriaLyy/Aria)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arialyy.aria.core.download;

import android.os.Parcel;
import android.os.Parcelable;
import com.arialyy.aria.core.inf.AbsNormalEntity;
import com.arialyy.aria.core.inf.AbsTaskEntity;
import com.arialyy.aria.orm.Primary;

/**
 * Created by lyy on 2015/12/25.
 * 下载实体
 */
public class DownloadEntity extends AbsNormalEntity implements Parcelable {
  private String downloadUrl = ""; //下载路径
  @Primary private String downloadPath = ""; //保存路径
  private boolean isRedirect = false; //是否重定向
  private String redirectUrl = ""; //重定向链接

  /**
   * 所属任务组
   */
  private String groupName = "";

  /**
   * 通过{@link AbsTaskEntity#md5Key}从服务器的返回信息中获取的文件md5信息，如果服务器没有返回，则不会设置该信息
   * 如果你已经设置了该任务的MD5信息，Aria也不会从服务器返回的信息中获取该信息
   */
  private String md5Code = "";

  /**
   * 通过{@link AbsTaskEntity#dispositionKey}从服务器的返回信息中获取的文件描述信息
   */
  private String disposition = "";

  /**
   * 从disposition获取到的文件名，如果可以获取到，则会赋值到这个字段
   */
  private String serverFileName = "";

  @Override public String getKey() {
    return downloadUrl;
  }

  public DownloadEntity() {
  }

  @Override public String toString() {
    return "DownloadEntity{"
        + "downloadUrl='"
        + downloadUrl
        + '\''
        + ", downloadPath='"
        + downloadPath
        + '\''
        + ", isRedirect="
        + isRedirect
        + ", redirectUrl='"
        + redirectUrl
        + '\''
        + ", groupName='"
        + groupName
        + '\''
        + ", md5Code='"
        + md5Code
        + '\''
        + ", disposition='"
        + disposition
        + '\''
        + ", serverFileName='"
        + serverFileName
        + '\''
        + '}';
  }

  public String getMd5Code() {
    return md5Code;
  }

  public void setMd5Code(String md5Code) {
    this.md5Code = md5Code;
  }

  public String getDisposition() {
    return disposition;
  }

  public void setDisposition(String disposition) {
    this.disposition = disposition;
  }

  public String getServerFileName() {
    return serverFileName;
  }

  public void setServerFileName(String serverFileName) {
    this.serverFileName = serverFileName;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getDownloadUrl() {
    return downloadUrl;
  }

  public DownloadEntity setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

  public String getDownloadPath() {
    return downloadPath;
  }

  public DownloadEntity setDownloadPath(String downloadPath) {
    this.downloadPath = downloadPath;
    return this;
  }

  @Override public DownloadEntity clone() throws CloneNotSupportedException {
    return (DownloadEntity) super.clone();
  }

  public boolean isRedirect() {
    return isRedirect;
  }

  public void setRedirect(boolean redirect) {
    isRedirect = redirect;
  }

  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeString(this.downloadUrl);
    dest.writeString(this.downloadPath);
    dest.writeByte(this.isRedirect ? (byte) 1 : (byte) 0);
    dest.writeString(this.redirectUrl);
    dest.writeString(this.groupName);
    dest.writeString(this.md5Code);
    dest.writeString(this.disposition);
    dest.writeString(this.serverFileName);
  }

  protected DownloadEntity(Parcel in) {
    super(in);
    this.downloadUrl = in.readString();
    this.downloadPath = in.readString();
    this.isRedirect = in.readByte() != 0;
    this.redirectUrl = in.readString();
    this.groupName = in.readString();
    this.md5Code = in.readString();
    this.disposition = in.readString();
    this.serverFileName = in.readString();
  }

  public static final Creator<DownloadEntity> CREATOR = new Creator<DownloadEntity>() {
    @Override public DownloadEntity createFromParcel(Parcel source) {
      return new DownloadEntity(source);
    }

    @Override public DownloadEntity[] newArray(int size) {
      return new DownloadEntity[size];
    }
  };
}