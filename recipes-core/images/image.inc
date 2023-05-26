WGUI_APPS ?= " \
	eog \
	evince \
	file-roller \
	gnome-calendar \
	gnome-calculator \
	gnome-disk-utility \
	gnome-keyring \
	gnome-online-accounts \
	gnome-control-center \
	gnome-software \
	gnome-system-monitor \
	gnome-text-editor \
	gsettings-desktop-schemas \
	gvfs \
	gvfsd-trash \
	librsvg-gtk \
	nautilus \
	nwg-look \
	pavucontrol \
"

WCONSOLE_TOOLS ?= " \
	bash \
	bzip2 \
	coreutils \
	coreutils-stdbuf \
	curl \
	dosfstools \
	e2fsprogs \
	findutils \
	flatpak \
	gawk \
	git \
	grep \
	gzip \
	htop \
	imagemagick \
	iputils \
	less \
	libusb1 \
	nano \
	pamixer \
	playerctl \
	procps \
	psmisc \
	pv \
	rsync \
	sed \
	shadow \
	sudo \
	tar \
	usbutils \
	util-linux \
	util-linux-agetty \
	util-linux-fstrim \
	which \
	xprop \
	xz \
"

WSYSTEM_CONF ?= " \
	adw-gtk3 \
	ca-certificates \
	capitaine-cursors \
	cups-filters \
	cups-pk-helper \
	exfatprogs \
	gstreamer1.0-libav \
	gstreamer1.0-plugins-bad \
	gstreamer1.0-plugins-ugly \
	gtk4-printbackend-cups \
	gtk4-printbackend-file \
	libcanberra-pulse \
	linux-firmware \
	nfs-export-public \
	packagegroup-fonts-truetype \
	resize-helper \
	shared-mime-info \
	shared-mime-info-data \
	sound-theme-freedesktop \
	steam-udev-rules \
	system-config \
	system-config-flathub \
	systemd-extra-utils \
	tela-circle-icon-theme \
	tzdata \
	tzdata-europe \
	udev-rules-udisks-hide-bootpart \
	webp-pixbuf-loader \
	wireless-regdb-static \
	xdg-user-dirs \
	xdg-desktop-portal \
	xkeyboard-config \
	xorg-minimal-fonts \
	xprop \
	xwayland \	
"

WSERVICES ?= " \
	autofs \
	avahi-utils \
	cifs-utils \
	cups \
	cups-lib \
	cups-libimage \
	fuse3 \
	fuse3-utils \
	geoclue \
	libavahi-libevent \
	libavahi-common \
	libavahi-core \
	libavahi-client \
	libavahi-glib \
	libavahi-gobject \
	nfs-utils \
	nfs-utils-client \
	ntp \
	pipewire \
	pulseaudio-user-service \
	rpcbind \
	rtkit \
	samba \
	samba-base \
	upower \
"

WCOMMERCIAL ?= " \
	ffmpeg \
"

WGLIBC ?= " \
	glibc-binary-localedata-cs-cz \
	glibc-binary-localedata-de-de \
	glibc-binary-localedata-en-us \
	glibc-binary-localedata-es-es \
	glibc-binary-localedata-fr-fr \
	glibc-binary-localedata-pl-pl \
	glibc-binary-localedata-ru-ru \
	glibc-charmap-utf-8 \
	localedef \
"

IMAGE_INSTALL += " \
	${WWINDOW_MANAGER} \
	${WGUI_APPS} \
	${WCONSOLE_TOOLS} \
	${WSYSTEM_CONF} \
	${WSERVICES} \
	${@bb.utils.contains('TCLIBC', 'glibc', '${WGLIBC}', '', d)} \
	${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', '${WCOMMERCIAL}', '', d)} \
"