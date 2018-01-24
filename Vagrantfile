Vagrant.configure(2) do |config|

  config.vm.box = "ubuntu/trusty64"

  config.vm.provider "virtualbox" do |vb|
     vb.gui = true
  
     vb.memory = "4096"
  end

  config.vm.provision "shell",  run: "always", inline: <<-SHELL   
    sudo echo "LANG=fr_FR.UTF-8" >> /etc/environment
    sudo echo "LANGUAGE=fr_FR.UTF-8" >> /etc/environment
    sudo echo "LC_ALL=fr_FR.UTF-8" >> /etc/environment
    sudo echo "LC_CTYPE=fr_FR.UTF-8" >> /etc/environment
    
    sudo useradd  -d /home/student -p "$(openssl passwd -1 1234)" student
    sudo chown student /home/student
    
    sudo apt-get -y install language-pack-fr-base language-pack-fr
    sudo sed -ie '/^XKBLAYOUT=/s/".*"/"fr"/' /etc/default/keyboard && udevadm trigger --subsystem-match=input --action=change
    sudo loadkeys fr          
    
  SHELL
  
  config.vm.provision "shell", inline: <<-SHELL 
    wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | sudo apt-key add - 
    sudo sh -c 'echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
    sudo add-apt-repository -y ppa:webupd8team/java
    sudo apt-get update 
    sudo apt-get -y install google-chrome-stable 
    sudo sed -ie '/^Exec=/s/$/ --no-sandbox/' /usr/share/applications/google-chrome.desktop
    
    echo debconf shared/accepted-oracle-license-v1-1 select true | sudo debconf-set-selections 
    echo debconf shared/accepted-oracle-license-v1-1 seen true | sudo debconf-set-selections
    sudo apt-get -y install oracle-java8-installer
    
    sudo apt-get install -y xfce4 virtualbox-guest-dkms virtualbox-guest-utils virtualbox-guest-x11
    sudo apt-get install gnome-icon-theme-full tango-icon-theme
    sudo echo "allowed_users=anybody" > /etc/X11/Xwrapper.config
  
    sudo wget -O /opt/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz http://ftp.fau.de/eclipse/technology/epp/downloads/release/luna/SR2/eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
    cd /opt/ && sudo tar -zxvf eclipse-java-luna-SR2-linux-gtk-x86_64.tar.gz
    sudo cp /vagrant/eclipse.desktop /usr/share/applications/eclipse.desktop
  SHELL
end
